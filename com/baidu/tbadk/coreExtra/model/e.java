package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ckE;
    private String ckF;
    private String ckG;
    private String ckH;
    private String ckK;
    private String ckL;
    private String ckM;
    private String ckN;
    private String ckO;
    private String ckP;
    private int ckm = 0;
    private int ckn = 0;
    private int cko = 0;
    private int ckp = 0;
    private int ckq = 0;
    private int ckr = 0;
    private int cks = 0;
    private int ckt = 0;
    private int cku = 0;
    private int ckv = 0;
    private int ckw = 0;
    private int ckx = 0;
    private int cky = 0;
    private int ckz = 0;
    private int ckA = 0;
    private int ckB = 0;
    private boolean ckC = true;
    private boolean ckD = true;
    private HashMap<String, String> ckI = new HashMap<>();
    private HashMap<String, String> ckJ = new HashMap<>();
    private List<a> ckQ = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String ckR;
        public String ckS;
        public int ckT;
        public String ckU;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void apo() {
        HashMap<String, String> apE = apE();
        Set<String> keySet = apE.keySet();
        if (keySet.size() != 1) {
            pB(null);
        } else {
            pB(apE.get(keySet.iterator().next()));
        }
    }

    public void app() {
        HashMap<String, String> apK = apK();
        Set<String> keySet = apK.keySet();
        if (keySet.size() != 1) {
            pH(null);
        } else {
            pH(apK.get(keySet.iterator().next()));
        }
    }

    public int apq() {
        return this.ckm;
    }

    public void jD(int i) {
        this.ckm = i;
    }

    public int apr() {
        return this.ckp;
    }

    public void jE(int i) {
        this.ckp = i;
    }

    public int aps() {
        return this.ckq;
    }

    public int apt() {
        return this.cks;
    }

    public void jF(int i) {
        this.cks = i;
    }

    public int apu() {
        return this.ckw;
    }

    public void jG(int i) {
        this.ckw = i;
    }

    public int apv() {
        return this.ckv;
    }

    public void jH(int i) {
        this.ckv = i;
    }

    public int apw() {
        return this.ckm;
    }

    public int apx() {
        return this.cko;
    }

    public void jI(int i) {
        this.cko = i;
    }

    public boolean apy() {
        return this.ckC;
    }

    public void eS(boolean z) {
        this.ckC = z;
    }

    public String apz() {
        return this.ckE;
    }

    public void pA(String str) {
        this.ckE = str;
    }

    public String apA() {
        return this.ckK;
    }

    public void pB(String str) {
        this.ckK = str;
    }

    public void pC(String str) {
        this.ckL = str;
    }

    public int apB() {
        return this.ckn;
    }

    public void jJ(int i) {
        this.ckn = i;
    }

    public void pD(String str) {
        this.ckM = str;
    }

    public String apC() {
        return this.ckO;
    }

    public String apD() {
        return this.ckP;
    }

    public HashMap<String, String> apE() {
        return this.ckI;
    }

    public int apF() {
        return this.ckr;
    }

    public void jK(int i) {
        this.ckr = i;
    }

    public int apG() {
        return this.ckt;
    }

    public void jL(int i) {
        this.ckt = i;
    }

    public int apH() {
        return this.ckx;
    }

    public void jM(int i) {
        this.ckx = i;
    }

    public void pE(String str) {
        this.ckF = str;
    }

    public void pF(String str) {
        this.ckG = str;
    }

    public int apI() {
        return this.cku;
    }

    public void jN(int i) {
        this.cku = i;
    }

    public String apJ() {
        return this.ckH;
    }

    public void pG(String str) {
        this.ckH = str;
    }

    public HashMap<String, String> apK() {
        return this.ckJ;
    }

    public String apL() {
        return this.ckN;
    }

    public void pH(String str) {
        this.ckN = str;
    }

    public int apM() {
        return this.ckz;
    }

    public void jO(int i) {
        this.ckz = i;
    }

    public int apN() {
        return this.ckA;
    }

    public void jP(int i) {
        this.ckA = i;
    }

    public List<a> apO() {
        return this.ckQ;
    }

    public int apP() {
        return this.ckB;
    }

    public void jQ(int i) {
        this.ckB = i;
    }
}
