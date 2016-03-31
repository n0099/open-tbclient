package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ame;
    private String amf;
    private String amg;
    private String amh;
    private String amk;
    private String aml;
    private String amm;
    private String amn;
    private String amo;
    private String amp;
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
    private int alX = 0;
    private int alY = 0;
    private int alZ = 0;
    private int ama = 0;
    private int amb = 0;
    private boolean amc = true;
    private boolean amd = true;
    private HashMap<String, String> ami = new HashMap<>();
    private HashMap<String, String> amj = new HashMap<>();
    private String amq = null;
    private String amr = null;
    private List<b> ams = new ArrayList();
    private List<a> amt = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int amu;
        public int amv;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int amu;
        public int amv;
        public String amw;
        public String amx;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Au() {
        HashMap<String, String> AK = AK();
        Set<String> keySet = AK.keySet();
        if (keySet.size() != 1) {
            ev(null);
        } else {
            ev(AK.get(keySet.iterator().next()));
        }
    }

    public void Av() {
        HashMap<String, String> AQ = AQ();
        Set<String> keySet = AQ.keySet();
        if (keySet.size() != 1) {
            eB(null);
        } else {
            eB(AQ.get(keySet.iterator().next()));
        }
    }

    public int Aw() {
        return this.alI;
    }

    public void dM(int i) {
        this.alI = i;
    }

    public int Ax() {
        return this.alL;
    }

    public void dN(int i) {
        this.alL = i;
    }

    public int Ay() {
        return this.alM;
    }

    public int Az() {
        return this.alQ;
    }

    public void dO(int i) {
        this.alQ = i;
    }

    public int AA() {
        return this.alU;
    }

    public void dP(int i) {
        this.alU = i;
    }

    public int AB() {
        return this.alT;
    }

    public void dQ(int i) {
        this.alT = i;
    }

    public int AC() {
        return this.alI;
    }

    public int AD() {
        return this.alK;
    }

    public void dR(int i) {
        this.alK = i;
    }

    public boolean AE() {
        return this.amc;
    }

    public void aY(boolean z) {
        this.amc = z;
    }

    public String AF() {
        return this.ame;
    }

    public void eu(String str) {
        this.ame = str;
    }

    public String AG() {
        return this.amk;
    }

    public void ev(String str) {
        this.amk = str;
    }

    public void ew(String str) {
        this.aml = str;
    }

    public int AH() {
        return this.alJ;
    }

    public void dS(int i) {
        this.alJ = i;
    }

    public void ex(String str) {
        this.amm = str;
    }

    public String AI() {
        return this.amo;
    }

    public String AJ() {
        return this.amp;
    }

    public HashMap<String, String> AK() {
        return this.ami;
    }

    public int AL() {
        return this.alN;
    }

    public void dT(int i) {
        this.alN = i;
    }

    public int AM() {
        return this.alR;
    }

    public void dU(int i) {
        this.alR = i;
    }

    public int AN() {
        return this.alV;
    }

    public void dV(int i) {
        this.alV = i;
    }

    public void ey(String str) {
        this.amf = str;
    }

    public void ez(String str) {
        this.amg = str;
    }

    public int AO() {
        return this.alS;
    }

    public void dW(int i) {
        this.alS = i;
    }

    public String AP() {
        return this.amh;
    }

    public void eA(String str) {
        this.amh = str;
    }

    public HashMap<String, String> AQ() {
        return this.amj;
    }

    public String AR() {
        return this.amn;
    }

    public void eB(String str) {
        this.amn = str;
    }

    public int AS() {
        return this.alO;
    }

    public int AT() {
        return this.alP;
    }

    public void dX(int i) {
        this.alO = i;
    }

    public void dY(int i) {
        this.alP = i;
    }

    public void eC(String str) {
        this.amq = str;
    }

    public void eD(String str) {
        this.amr = str;
    }

    public int AU() {
        return this.alX;
    }

    public void dZ(int i) {
        this.alX = i;
    }

    public int AV() {
        return this.alY;
    }

    public void ea(int i) {
        this.alY = i;
    }

    public int AW() {
        return this.alZ;
    }

    public void eb(int i) {
        this.alZ = i;
    }

    public int AX() {
        return this.ama;
    }

    public void ec(int i) {
        this.ama = i;
    }

    public List<b> AY() {
        return this.ams;
    }

    public List<a> AZ() {
        return this.amt;
    }

    public int Ba() {
        return this.amb;
    }

    public void ed(int i) {
        this.amb = i;
    }
}
