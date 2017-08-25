/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entity.Customers;
import Entity.Employees;
import Entity.Orders;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author felesiah
 */
public class Testing {
    
    public static void main(String[] args) {
        
        getEmployeCount();
        getCustomerInTheCity("Bacelona"); 
        getOrdersOnHold();
//      getOrdersOnHold(144);
        System.out.println("Employees:"+ " "+ getEmployeCount());
        System.out.println(" Customers in Bacelorna:"+ " "+ getCustomerInTheCity("Bacelona"));
        System.out.println("Orders on hold:"+ " " +getOrdersOnHold());
         
       
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_classicmodels_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();   
         Query q= em.createQuery("SELECT o FROM Orders o where o.status = :status and o.customerNumber = :customerNumber");
         q.setParameter("status","ON HOLD");
         List<Orders> orders = (List<Orders>)q.getResultList();
        System.out.println(orders);  
        
    }
    
    public static Long getEmployeCount(){
        
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_classicmodels_jar_1.0-SNAPSHOTPU");
      EntityManager em = emf.createEntityManager();   
        Query q= em.createQuery("Select count (e) From Employees e");
          Long result = (Long) q.getSingleResult();
   
        return result;
        
    }
    
    public  static List<Customers> getCustomerInTheCity (String city){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_classicmodels_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();   
         Query q= em.createNamedQuery("Customers.findByCity");
         q.setParameter("city","Barcelona");
         List<Customers> customer = (List<Customers>)q.getResultList();
   
        return customer;
        
        
    }
     
    public static Employees getEmployeMaxCustomers(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_classicmodels_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();   
         Query q= em.createQuery("Select e from Employees e");
         q.setParameter("city","Barcelona");
         List<Customers> customer = (List<Customers>)q.getResultList();
   
        return null;     
    }
    
    public static List<Orders>getOrdersOnHold(){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_classicmodels_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();   
         Query q= em.createNamedQuery("Orders.findByStatus");
         q.setParameter("status","ON HOLD");
         List<Orders> orders = (List<Orders>)q.getResultList();
   
        return orders;  
        
        
    }
    
    public  static int getOrdersOnHold(int customerNumber){
         customerNumber = 144;
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_classicmodels_jar_1.0-SNAPSHOTPU");
         EntityManager em = emf.createEntityManager();   
         Query q= em.createQuery("SELECT o FROM Orders o, Customers c where o.status = :status and c.customerNumber = :customerNumber");
         q.setParameter("status","ON HOLD");
         q.setParameter("customerNumber",customerNumber);
         int orders =  (int) q.getSingleResult();
   
        return orders;  
         
         
     }
}
