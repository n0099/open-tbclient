package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aMV;
    private String aMW;
    private String aMX;
    private String aMY;
    private String aNb;
    private String aNc;
    private String aNd;
    private String aNe;
    private String aNf;
    private String aNg;
    private int aMD = 0;
    private int aME = 0;
    private int aMF = 0;
    private int aMG = 0;
    private int aMH = 0;
    private int aMI = 0;
    private int aMJ = 0;
    private int aMK = 0;
    private int aML = 0;
    private int aMM = 0;
    private int aMN = 0;
    private int aMO = 0;
    private int aMP = 0;
    private int aMQ = 0;
    private int aMR = 0;
    private int aMS = 0;
    private boolean aMT = true;
    private boolean aMU = true;
    private HashMap<String, String> aMZ = new HashMap<>();
    private HashMap<String, String> aNa = new HashMap<>();
    private List<a> aNh = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aNi;
        public String aNj;
        public int aNk;
        public String aNl;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void HT() {
        HashMap<String, String> Ij = Ij();
        Set<String> keySet = Ij.keySet();
        if (keySet.size() != 1) {
            gw(null);
        } else {
            gw(Ij.get(keySet.iterator().next()));
        }
    }

    public void HU() {
        HashMap<String, String> Ip = Ip();
        Set<String> keySet = Ip.keySet();
        if (keySet.size() != 1) {
            gC(null);
        } else {
            gC(Ip.get(keySet.iterator().next()));
        }
    }

    public int HV() {
        return this.aMD;
    }

    public void ex(int i) {
        this.aMD = i;
    }

    public int HW() {
        return this.aMG;
    }

    public void ey(int i) {
        this.aMG = i;
    }

    public int HX() {
        return this.aMH;
    }

    public int HY() {
        return this.aMJ;
    }

    public void ez(int i) {
        this.aMJ = i;
    }

    public int HZ() {
        return this.aMN;
    }

    public void eA(int i) {
        this.aMN = i;
    }

    public int Ia() {
        return this.aMM;
    }

    public void eB(int i) {
        this.aMM = i;
    }

    public int Ib() {
        return this.aMD;
    }

    public int Ic() {
        return this.aMF;
    }

    public void eC(int i) {
        this.aMF = i;
    }

    public boolean Id() {
        return this.aMT;
    }

    public void bM(boolean z) {
        this.aMT = z;
    }

    public String Ie() {
        return this.aMV;
    }

    public void gv(String str) {
        this.aMV = str;
    }

    public String If() {
        return this.aNb;
    }

    public void gw(String str) {
        this.aNb = str;
    }

    public void gx(String str) {
        this.aNc = str;
    }

    public int Ig() {
        return this.aME;
    }

    public void eD(int i) {
        this.aME = i;
    }

    public void gy(String str) {
        this.aNd = str;
    }

    public String Ih() {
        return this.aNf;
    }

    public String Ii() {
        return this.aNg;
    }

    public HashMap<String, String> Ij() {
        return this.aMZ;
    }

    public int Ik() {
        return this.aMI;
    }

    public void eE(int i) {
        this.aMI = i;
    }

    public int Il() {
        return this.aMK;
    }

    public void eF(int i) {
        this.aMK = i;
    }

    public int Im() {
        return this.aMO;
    }

    public void eG(int i) {
        this.aMO = i;
    }

    public void gz(String str) {
        this.aMW = str;
    }

    public void gA(String str) {
        this.aMX = str;
    }

    public int In() {
        return this.aML;
    }

    public void eH(int i) {
        this.aML = i;
    }

    public String Io() {
        return this.aMY;
    }

    public void gB(String str) {
        this.aMY = str;
    }

    public HashMap<String, String> Ip() {
        return this.aNa;
    }

    public String Iq() {
        return this.aNe;
    }

    public void gC(String str) {
        this.aNe = str;
    }

    public int Ir() {
        return this.aMQ;
    }

    public void eI(int i) {
        this.aMQ = i;
    }

    public int Is() {
        return this.aMR;
    }

    public void eJ(int i) {
        this.aMR = i;
    }

    public List<a> It() {
        return this.aNh;
    }

    public int Iu() {
        return this.aMS;
    }

    public void eK(int i) {
        this.aMS = i;
    }
}
