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
    private String amD;
    private String amE;
    private String amF;
    private String amu;
    private String amv;
    private String amw;
    private String amx;
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
    private int amp = 0;
    private int amq = 0;
    private int amr = 0;
    private boolean ams = true;
    private boolean amt = true;
    private HashMap<String, String> amy = new HashMap<>();
    private HashMap<String, String> amz = new HashMap<>();
    private String amG = null;
    private String amH = null;
    private List<b> amI = new ArrayList();
    private List<a> amJ = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int amK;
        public int amL;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int amK;
        public int amL;
        public String amM;
        public String amN;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zD() {
        HashMap<String, String> zT = zT();
        Set<String> keySet = zT.keySet();
        if (keySet.size() != 1) {
            ez(null);
        } else {
            ez(zT.get(keySet.iterator().next()));
        }
    }

    public void zE() {
        HashMap<String, String> zZ = zZ();
        Set<String> keySet = zZ.keySet();
        if (keySet.size() != 1) {
            eF(null);
        } else {
            eF(zZ.get(keySet.iterator().next()));
        }
    }

    public int zF() {
        return this.alY;
    }

    public void dL(int i) {
        this.alY = i;
    }

    public int zG() {
        return this.amb;
    }

    public void dM(int i) {
        this.amb = i;
    }

    public int zH() {
        return this.amc;
    }

    public int zI() {
        return this.amg;
    }

    public void dN(int i) {
        this.amg = i;
    }

    public int zJ() {
        return this.amk;
    }

    public void dO(int i) {
        this.amk = i;
    }

    public int zK() {
        return this.amj;
    }

    public void dP(int i) {
        this.amj = i;
    }

    public int zL() {
        return this.alY;
    }

    public int zM() {
        return this.ama;
    }

    public void dQ(int i) {
        this.ama = i;
    }

    public boolean zN() {
        return this.ams;
    }

    public void bj(boolean z) {
        this.ams = z;
    }

    public String zO() {
        return this.amu;
    }

    public void ey(String str) {
        this.amu = str;
    }

    public String zP() {
        return this.amA;
    }

    public void ez(String str) {
        this.amA = str;
    }

    public void eA(String str) {
        this.amB = str;
    }

    public int zQ() {
        return this.alZ;
    }

    public void dR(int i) {
        this.alZ = i;
    }

    public void eB(String str) {
        this.amC = str;
    }

    public String zR() {
        return this.amE;
    }

    public String zS() {
        return this.amF;
    }

    public HashMap<String, String> zT() {
        return this.amy;
    }

    public int zU() {
        return this.amd;
    }

    public void dS(int i) {
        this.amd = i;
    }

    public int zV() {
        return this.amh;
    }

    public void dT(int i) {
        this.amh = i;
    }

    public int zW() {
        return this.aml;
    }

    public void dU(int i) {
        this.aml = i;
    }

    public void eC(String str) {
        this.amv = str;
    }

    public void eD(String str) {
        this.amw = str;
    }

    public int zX() {
        return this.ami;
    }

    public void dV(int i) {
        this.ami = i;
    }

    public String zY() {
        return this.amx;
    }

    public void eE(String str) {
        this.amx = str;
    }

    public HashMap<String, String> zZ() {
        return this.amz;
    }

    public String Aa() {
        return this.amD;
    }

    public void eF(String str) {
        this.amD = str;
    }

    public int Ab() {
        return this.ame;
    }

    public int Ac() {
        return this.amf;
    }

    public void dW(int i) {
        this.ame = i;
    }

    public void dX(int i) {
        this.amf = i;
    }

    public void eG(String str) {
        this.amG = str;
    }

    public void eH(String str) {
        this.amH = str;
    }

    public int Ad() {
        return this.amn;
    }

    public void dY(int i) {
        this.amn = i;
    }

    public int Ae() {
        return this.amo;
    }

    public void dZ(int i) {
        this.amo = i;
    }

    public int Af() {
        return this.amp;
    }

    public void ea(int i) {
        this.amp = i;
    }

    public int Ag() {
        return this.amq;
    }

    public void eb(int i) {
        this.amq = i;
    }

    public List<b> Ah() {
        return this.amI;
    }

    public List<a> Ai() {
        return this.amJ;
    }

    public int Aj() {
        return this.amr;
    }

    public void ec(int i) {
        this.amr = i;
    }
}
