package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String alZ;
    private String ama;
    private String amb;
    private String amc;
    private String amf;
    private String amg;
    private String amh;
    private String ami;
    private String amj;
    private String amk;
    private int alD = 0;
    private int alE = 0;
    private int alF = 0;
    private int alG = 0;
    private int alH = 0;
    private int alI = 0;
    private int alJ = 0;
    private int alK = 0;
    private int alL = 0;
    private int alM = 0;
    private int alN = 0;
    private int alO = 0;
    private int alP = 0;
    private int alQ = 0;
    private int alR = 0;
    private int alS = 0;
    private int alT = 0;
    private int alU = 0;
    private int alV = 0;
    private int alW = 0;
    private boolean alX = true;
    private boolean alY = true;
    private HashMap<String, String> amd = new HashMap<>();
    private HashMap<String, String> ame = new HashMap<>();
    private String aml = null;
    private String amm = null;
    private List<b> amn = new ArrayList();
    private List<a> amo = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int amp;
        public int amq;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int amp;
        public int amq;
        public String amr;
        public String ams;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zJ() {
        HashMap<String, String> zZ = zZ();
        Set<String> keySet = zZ.keySet();
        if (keySet.size() != 1) {
            eA(null);
        } else {
            eA(zZ.get(keySet.iterator().next()));
        }
    }

    public void zK() {
        HashMap<String, String> Af = Af();
        Set<String> keySet = Af.keySet();
        if (keySet.size() != 1) {
            eG(null);
        } else {
            eG(Af.get(keySet.iterator().next()));
        }
    }

    public int zL() {
        return this.alD;
    }

    public void dH(int i) {
        this.alD = i;
    }

    public int zM() {
        return this.alG;
    }

    public void dI(int i) {
        this.alG = i;
    }

    public int zN() {
        return this.alH;
    }

    public int zO() {
        return this.alL;
    }

    public void dJ(int i) {
        this.alL = i;
    }

    public int zP() {
        return this.alP;
    }

    public void dK(int i) {
        this.alP = i;
    }

    public int zQ() {
        return this.alO;
    }

    public void dL(int i) {
        this.alO = i;
    }

    public int zR() {
        return this.alD;
    }

    public int zS() {
        return this.alF;
    }

    public void dM(int i) {
        this.alF = i;
    }

    public boolean zT() {
        return this.alX;
    }

    public void bf(boolean z) {
        this.alX = z;
    }

    public String zU() {
        return this.alZ;
    }

    public void ez(String str) {
        this.alZ = str;
    }

    public String zV() {
        return this.amf;
    }

    public void eA(String str) {
        this.amf = str;
    }

    public void eB(String str) {
        this.amg = str;
    }

    public int zW() {
        return this.alE;
    }

    public void dN(int i) {
        this.alE = i;
    }

    public void eC(String str) {
        this.amh = str;
    }

    public String zX() {
        return this.amj;
    }

    public String zY() {
        return this.amk;
    }

    public HashMap<String, String> zZ() {
        return this.amd;
    }

    public int Aa() {
        return this.alI;
    }

    public void dO(int i) {
        this.alI = i;
    }

    public int Ab() {
        return this.alM;
    }

    public void dP(int i) {
        this.alM = i;
    }

    public int Ac() {
        return this.alQ;
    }

    public void dQ(int i) {
        this.alQ = i;
    }

    public void eD(String str) {
        this.ama = str;
    }

    public void eE(String str) {
        this.amb = str;
    }

    public int Ad() {
        return this.alN;
    }

    public void dR(int i) {
        this.alN = i;
    }

    public String Ae() {
        return this.amc;
    }

    public void eF(String str) {
        this.amc = str;
    }

    public HashMap<String, String> Af() {
        return this.ame;
    }

    public String Ag() {
        return this.ami;
    }

    public void eG(String str) {
        this.ami = str;
    }

    public int Ah() {
        return this.alJ;
    }

    public int Ai() {
        return this.alK;
    }

    public void dS(int i) {
        this.alJ = i;
    }

    public void dT(int i) {
        this.alK = i;
    }

    public void eH(String str) {
        this.aml = str;
    }

    public void eI(String str) {
        this.amm = str;
    }

    public int Aj() {
        return this.alS;
    }

    public void dU(int i) {
        this.alS = i;
    }

    public int Ak() {
        return this.alT;
    }

    public void dV(int i) {
        this.alT = i;
    }

    public int Al() {
        return this.alU;
    }

    public void dW(int i) {
        this.alU = i;
    }

    public int Am() {
        return this.alV;
    }

    public void dX(int i) {
        this.alV = i;
    }

    public List<b> An() {
        return this.amn;
    }

    public List<a> Ao() {
        return this.amo;
    }

    public int Ap() {
        return this.alW;
    }

    public void dY(int i) {
        this.alW = i;
    }
}
