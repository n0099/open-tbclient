package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class h {
    private String RR;
    private String RS;
    private String RT;
    private String RU;
    private String RX;
    private String RY;
    private String RZ;
    private String Sa;
    private String Sb;
    private String Sc;
    private int Rw = 0;
    private int Rx = 0;
    private int Ry = 0;
    private int Rz = 0;
    private int RA = 0;
    private int RB = 0;
    private int RC = 0;
    private int RE = 0;
    private int RF = 0;
    private int RG = 0;
    private int RH = 0;
    private int RI = 0;
    private int RJ = 0;
    private int RK = 0;
    private int RL = 0;
    private int RM = 0;
    private int RN = 0;
    private int RO = 0;
    private boolean RP = true;
    private boolean RQ = true;
    private HashMap<String, String> RV = new HashMap<>();
    private HashMap<String, String> RW = new HashMap<>();
    private String Sd = null;
    private String Se = null;
    private List<i> Sf = new ArrayList();

    public void sr() {
        HashMap<String, String> sH = sH();
        Set<String> keySet = sH.keySet();
        if (keySet.size() != 1) {
            ds(null);
        } else {
            ds(sH.get(keySet.iterator().next()));
        }
    }

    public void ss() {
        HashMap<String, String> sN = sN();
        Set<String> keySet = sN.keySet();
        if (keySet.size() != 1) {
            dy(null);
        } else {
            dy(sN.get(keySet.iterator().next()));
        }
    }

    public int st() {
        return this.Rw;
    }

    public void cy(int i) {
        this.Rw = i;
    }

    public int su() {
        return this.Rz;
    }

    public void cz(int i) {
        this.Rz = i;
    }

    public int sv() {
        return this.RA;
    }

    public int sw() {
        return this.RF;
    }

    public void cA(int i) {
        this.RF = i;
    }

    public int sx() {
        return this.RJ;
    }

    public void cB(int i) {
        this.RJ = i;
    }

    public int sy() {
        return this.RI;
    }

    public void cC(int i) {
        this.RI = i;
    }

    public int sz() {
        return this.Rw;
    }

    public int sA() {
        return this.Ry;
    }

    public void cD(int i) {
        this.Ry = i;
    }

    public boolean sB() {
        return this.RP;
    }

    public void av(boolean z) {
        this.RP = z;
    }

    public String sC() {
        return this.RR;
    }

    public void dr(String str) {
        this.RR = str;
    }

    public String sD() {
        return this.RX;
    }

    public void ds(String str) {
        this.RX = str;
    }

    public void dt(String str) {
        this.RY = str;
    }

    public int sE() {
        return this.Rx;
    }

    public void cE(int i) {
        this.Rx = i;
    }

    public void du(String str) {
        this.RZ = str;
    }

    public String sF() {
        return this.Sb;
    }

    public String sG() {
        return this.Sc;
    }

    public HashMap<String, String> sH() {
        return this.RV;
    }

    public int sI() {
        return this.RB;
    }

    public void cF(int i) {
        this.RB = i;
    }

    public int sJ() {
        return this.RG;
    }

    public void cG(int i) {
        this.RG = i;
    }

    public int sK() {
        return this.RK;
    }

    public void cH(int i) {
        this.RK = i;
    }

    public void dv(String str) {
        this.RS = str;
    }

    public void dw(String str) {
        this.RT = str;
    }

    public int sL() {
        return this.RH;
    }

    public void cI(int i) {
        this.RH = i;
    }

    public String sM() {
        return this.RU;
    }

    public void dx(String str) {
        this.RU = str;
    }

    public HashMap<String, String> sN() {
        return this.RW;
    }

    public String sO() {
        return this.Sa;
    }

    public void dy(String str) {
        this.Sa = str;
    }

    public int sP() {
        return this.RC;
    }

    public int sQ() {
        return this.RE;
    }

    public void cJ(int i) {
        this.RC = i;
    }

    public void cK(int i) {
        this.RE = i;
    }

    public void dz(String str) {
        this.Sd = str;
    }

    public void dA(String str) {
        this.Se = str;
    }

    public int sR() {
        return this.RM;
    }

    public void cL(int i) {
        this.RM = i;
    }

    public int sS() {
        return this.RN;
    }

    public void cM(int i) {
        this.RN = i;
    }

    public List<i> sT() {
        return this.Sf;
    }

    public int sU() {
        return this.RO;
    }

    public void cN(int i) {
        this.RO = i;
    }
}
