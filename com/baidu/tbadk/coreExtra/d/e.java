package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String alA;
    private String alB;
    private String alC;
    private String alD;
    private String alG;
    private String alH;
    private String alI;
    private String alJ;
    private String alK;
    private String alL;
    private int ald = 0;
    private int ale = 0;
    private int alf = 0;
    private int alg = 0;
    private int alh = 0;
    private int ali = 0;
    private int alj = 0;
    private int alk = 0;
    private int alm = 0;
    private int aln = 0;
    private int alo = 0;
    private int alp = 0;
    private int alq = 0;
    private int alr = 0;
    private int als = 0;
    private int alt = 0;
    private int alu = 0;
    private int alv = 0;
    private int alw = 0;
    private int alx = 0;
    private boolean aly = true;
    private boolean alz = true;
    private HashMap<String, String> alE = new HashMap<>();
    private HashMap<String, String> alF = new HashMap<>();
    private String alM = null;
    private String alN = null;
    private List<b> alO = new ArrayList();
    private List<a> alP = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int alQ;
        public int alR;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int alQ;
        public int alR;
        public String alS;
        public String alT;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zy() {
        HashMap<String, String> zO = zO();
        Set<String> keySet = zO.keySet();
        if (keySet.size() != 1) {
            ew(null);
        } else {
            ew(zO.get(keySet.iterator().next()));
        }
    }

    public void zz() {
        HashMap<String, String> zU = zU();
        Set<String> keySet = zU.keySet();
        if (keySet.size() != 1) {
            eC(null);
        } else {
            eC(zU.get(keySet.iterator().next()));
        }
    }

    public int zA() {
        return this.ald;
    }

    public void dM(int i) {
        this.ald = i;
    }

    public int zB() {
        return this.alg;
    }

    public void dN(int i) {
        this.alg = i;
    }

    public int zC() {
        return this.alh;
    }

    public int zD() {
        return this.alm;
    }

    public void dO(int i) {
        this.alm = i;
    }

    public int zE() {
        return this.alq;
    }

    public void dP(int i) {
        this.alq = i;
    }

    public int zF() {
        return this.alp;
    }

    public void dQ(int i) {
        this.alp = i;
    }

    public int zG() {
        return this.ald;
    }

    public int zH() {
        return this.alf;
    }

    public void dR(int i) {
        this.alf = i;
    }

    public boolean zI() {
        return this.aly;
    }

    public void bj(boolean z) {
        this.aly = z;
    }

    public String zJ() {
        return this.alA;
    }

    public void ev(String str) {
        this.alA = str;
    }

    public String zK() {
        return this.alG;
    }

    public void ew(String str) {
        this.alG = str;
    }

    public void ex(String str) {
        this.alH = str;
    }

    public int zL() {
        return this.ale;
    }

    public void dS(int i) {
        this.ale = i;
    }

    public void ey(String str) {
        this.alI = str;
    }

    public String zM() {
        return this.alK;
    }

    public String zN() {
        return this.alL;
    }

    public HashMap<String, String> zO() {
        return this.alE;
    }

    public int zP() {
        return this.ali;
    }

    public void dT(int i) {
        this.ali = i;
    }

    public int zQ() {
        return this.aln;
    }

    public void dU(int i) {
        this.aln = i;
    }

    public int zR() {
        return this.alr;
    }

    public void dV(int i) {
        this.alr = i;
    }

    public void ez(String str) {
        this.alB = str;
    }

    public void eA(String str) {
        this.alC = str;
    }

    public int zS() {
        return this.alo;
    }

    public void dW(int i) {
        this.alo = i;
    }

    public String zT() {
        return this.alD;
    }

    public void eB(String str) {
        this.alD = str;
    }

    public HashMap<String, String> zU() {
        return this.alF;
    }

    public String zV() {
        return this.alJ;
    }

    public void eC(String str) {
        this.alJ = str;
    }

    public int zW() {
        return this.alj;
    }

    public int zX() {
        return this.alk;
    }

    public void dX(int i) {
        this.alj = i;
    }

    public void dY(int i) {
        this.alk = i;
    }

    public void eD(String str) {
        this.alM = str;
    }

    public void eE(String str) {
        this.alN = str;
    }

    public int zY() {
        return this.alt;
    }

    public void dZ(int i) {
        this.alt = i;
    }

    public int zZ() {
        return this.alu;
    }

    public void ea(int i) {
        this.alu = i;
    }

    public int Aa() {
        return this.alv;
    }

    public void eb(int i) {
        this.alv = i;
    }

    public int Ab() {
        return this.alw;
    }

    public void ec(int i) {
        this.alw = i;
    }

    public List<b> Ac() {
        return this.alO;
    }

    public List<a> Ad() {
        return this.alP;
    }

    public int Ae() {
        return this.alx;
    }

    public void ed(int i) {
        this.alx = i;
    }
}
