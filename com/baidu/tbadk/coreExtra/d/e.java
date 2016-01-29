package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String alN;
    private String alO;
    private String alP;
    private String alQ;
    private String alT;
    private String alU;
    private String alV;
    private String alW;
    private String alX;
    private String alY;
    private int alr = 0;
    private int als = 0;
    private int alt = 0;
    private int alu = 0;
    private int alv = 0;
    private int alw = 0;
    private int alx = 0;
    private int aly = 0;
    private int alz = 0;
    private int alA = 0;
    private int alB = 0;
    private int alC = 0;
    private int alD = 0;
    private int alE = 0;
    private int alF = 0;
    private int alG = 0;
    private int alH = 0;
    private int alI = 0;
    private int alJ = 0;
    private int alK = 0;
    private boolean alL = true;
    private boolean alM = true;
    private HashMap<String, String> alR = new HashMap<>();
    private HashMap<String, String> alS = new HashMap<>();
    private String alZ = null;
    private String ama = null;
    private List<b> amb = new ArrayList();
    private List<a> amc = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int amd;
        public int ame;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int amd;
        public int ame;
        public String amf;
        public String amg;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zR() {
        HashMap<String, String> Ah = Ah();
        Set<String> keySet = Ah.keySet();
        if (keySet.size() != 1) {
            eo(null);
        } else {
            eo(Ah.get(keySet.iterator().next()));
        }
    }

    public void zS() {
        HashMap<String, String> An = An();
        Set<String> keySet = An.keySet();
        if (keySet.size() != 1) {
            eu(null);
        } else {
            eu(An.get(keySet.iterator().next()));
        }
    }

    public int zT() {
        return this.alr;
    }

    public void dJ(int i) {
        this.alr = i;
    }

    public int zU() {
        return this.alu;
    }

    public void dK(int i) {
        this.alu = i;
    }

    public int zV() {
        return this.alv;
    }

    public int zW() {
        return this.alz;
    }

    public void dL(int i) {
        this.alz = i;
    }

    public int zX() {
        return this.alD;
    }

    public void dM(int i) {
        this.alD = i;
    }

    public int zY() {
        return this.alC;
    }

    public void dN(int i) {
        this.alC = i;
    }

    public int zZ() {
        return this.alr;
    }

    public int Aa() {
        return this.alt;
    }

    public void dO(int i) {
        this.alt = i;
    }

    public boolean Ab() {
        return this.alL;
    }

    public void aS(boolean z) {
        this.alL = z;
    }

    public String Ac() {
        return this.alN;
    }

    public void en(String str) {
        this.alN = str;
    }

    public String Ad() {
        return this.alT;
    }

    public void eo(String str) {
        this.alT = str;
    }

    public void ep(String str) {
        this.alU = str;
    }

    public int Ae() {
        return this.als;
    }

    public void dP(int i) {
        this.als = i;
    }

    public void eq(String str) {
        this.alV = str;
    }

    public String Af() {
        return this.alX;
    }

    public String Ag() {
        return this.alY;
    }

    public HashMap<String, String> Ah() {
        return this.alR;
    }

    public int Ai() {
        return this.alw;
    }

    public void dQ(int i) {
        this.alw = i;
    }

    public int Aj() {
        return this.alA;
    }

    public void dR(int i) {
        this.alA = i;
    }

    public int Ak() {
        return this.alE;
    }

    public void dS(int i) {
        this.alE = i;
    }

    public void er(String str) {
        this.alO = str;
    }

    public void es(String str) {
        this.alP = str;
    }

    public int Al() {
        return this.alB;
    }

    public void dT(int i) {
        this.alB = i;
    }

    public String Am() {
        return this.alQ;
    }

    public void et(String str) {
        this.alQ = str;
    }

    public HashMap<String, String> An() {
        return this.alS;
    }

    public String Ao() {
        return this.alW;
    }

    public void eu(String str) {
        this.alW = str;
    }

    public int Ap() {
        return this.alx;
    }

    public int Aq() {
        return this.aly;
    }

    public void dU(int i) {
        this.alx = i;
    }

    public void dV(int i) {
        this.aly = i;
    }

    public void ev(String str) {
        this.alZ = str;
    }

    public void ew(String str) {
        this.ama = str;
    }

    public int Ar() {
        return this.alG;
    }

    public void dW(int i) {
        this.alG = i;
    }

    public int As() {
        return this.alH;
    }

    public void dX(int i) {
        this.alH = i;
    }

    public int At() {
        return this.alI;
    }

    public void dY(int i) {
        this.alI = i;
    }

    public int Au() {
        return this.alJ;
    }

    public void dZ(int i) {
        this.alJ = i;
    }

    public List<b> Av() {
        return this.amb;
    }

    public List<a> Aw() {
        return this.amc;
    }

    public int Ax() {
        return this.alK;
    }

    public void ea(int i) {
        this.alK = i;
    }
}
