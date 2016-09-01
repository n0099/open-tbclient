package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String amA;
    private String amB;
    private String amC;
    private String amr;
    private String ams;
    private String amt;
    private String amu;
    private String amx;
    private String amy;
    private String amz;
    private int alV = 0;
    private int alW = 0;
    private int alX = 0;
    private int alY = 0;
    private int alZ = 0;
    private int ama = 0;
    private int amb = 0;
    private int amc = 0;
    private int amd = 0;
    private int ame = 0;
    private int amf = 0;
    private int amg = 0;
    private int amh = 0;
    private int ami = 0;
    private int amj = 0;
    private int amk = 0;
    private int aml = 0;
    private int amm = 0;
    private int amn = 0;
    private int amo = 0;
    private boolean amp = true;
    private boolean amq = true;
    private HashMap<String, String> amv = new HashMap<>();
    private HashMap<String, String> amw = new HashMap<>();
    private String amD = null;
    private String amE = null;
    private List<b> amF = new ArrayList();
    private List<a> amG = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int amH;
        public int amI;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int amH;
        public int amI;
        public String amJ;
        public String amK;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zG() {
        HashMap<String, String> zW = zW();
        Set<String> keySet = zW.keySet();
        if (keySet.size() != 1) {
            ex(null);
        } else {
            ex(zW.get(keySet.iterator().next()));
        }
    }

    public void zH() {
        HashMap<String, String> Ac = Ac();
        Set<String> keySet = Ac.keySet();
        if (keySet.size() != 1) {
            eD(null);
        } else {
            eD(Ac.get(keySet.iterator().next()));
        }
    }

    public int zI() {
        return this.alV;
    }

    public void dH(int i) {
        this.alV = i;
    }

    public int zJ() {
        return this.alY;
    }

    public void dI(int i) {
        this.alY = i;
    }

    public int zK() {
        return this.alZ;
    }

    public int zL() {
        return this.amd;
    }

    public void dJ(int i) {
        this.amd = i;
    }

    public int zM() {
        return this.amh;
    }

    public void dK(int i) {
        this.amh = i;
    }

    public int zN() {
        return this.amg;
    }

    public void dL(int i) {
        this.amg = i;
    }

    public int zO() {
        return this.alV;
    }

    public int zP() {
        return this.alX;
    }

    public void dM(int i) {
        this.alX = i;
    }

    public boolean zQ() {
        return this.amp;
    }

    public void bg(boolean z) {
        this.amp = z;
    }

    public String zR() {
        return this.amr;
    }

    public void ew(String str) {
        this.amr = str;
    }

    public String zS() {
        return this.amx;
    }

    public void ex(String str) {
        this.amx = str;
    }

    public void ey(String str) {
        this.amy = str;
    }

    public int zT() {
        return this.alW;
    }

    public void dN(int i) {
        this.alW = i;
    }

    public void ez(String str) {
        this.amz = str;
    }

    public String zU() {
        return this.amB;
    }

    public String zV() {
        return this.amC;
    }

    public HashMap<String, String> zW() {
        return this.amv;
    }

    public int zX() {
        return this.ama;
    }

    public void dO(int i) {
        this.ama = i;
    }

    public int zY() {
        return this.ame;
    }

    public void dP(int i) {
        this.ame = i;
    }

    public int zZ() {
        return this.ami;
    }

    public void dQ(int i) {
        this.ami = i;
    }

    public void eA(String str) {
        this.ams = str;
    }

    public void eB(String str) {
        this.amt = str;
    }

    public int Aa() {
        return this.amf;
    }

    public void dR(int i) {
        this.amf = i;
    }

    public String Ab() {
        return this.amu;
    }

    public void eC(String str) {
        this.amu = str;
    }

    public HashMap<String, String> Ac() {
        return this.amw;
    }

    public String Ad() {
        return this.amA;
    }

    public void eD(String str) {
        this.amA = str;
    }

    public int Ae() {
        return this.amb;
    }

    public int Af() {
        return this.amc;
    }

    public void dS(int i) {
        this.amb = i;
    }

    public void dT(int i) {
        this.amc = i;
    }

    public void eE(String str) {
        this.amD = str;
    }

    public void eF(String str) {
        this.amE = str;
    }

    public int Ag() {
        return this.amk;
    }

    public void dU(int i) {
        this.amk = i;
    }

    public int Ah() {
        return this.aml;
    }

    public void dV(int i) {
        this.aml = i;
    }

    public int Ai() {
        return this.amm;
    }

    public void dW(int i) {
        this.amm = i;
    }

    public int Aj() {
        return this.amn;
    }

    public void dX(int i) {
        this.amn = i;
    }

    public List<b> Ak() {
        return this.amF;
    }

    public List<a> Al() {
        return this.amG;
    }

    public int Am() {
        return this.amo;
    }

    public void dY(int i) {
        this.amo = i;
    }
}
