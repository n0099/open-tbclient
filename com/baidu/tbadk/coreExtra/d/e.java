package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aiA;
    private String aiD;
    private String aiE;
    private String aiF;
    private String aiG;
    private String aiH;
    private String aiI;
    private String aix;
    private String aiy;
    private String aiz;
    private int aib = 0;
    private int aic = 0;
    private int aid = 0;
    private int aie = 0;
    private int aif = 0;
    private int aig = 0;
    private int aih = 0;
    private int aii = 0;
    private int aij = 0;
    private int aik = 0;
    private int ail = 0;
    private int aim = 0;
    private int ain = 0;
    private int aio = 0;
    private int aip = 0;
    private int aiq = 0;
    private int air = 0;
    private int ais = 0;
    private int ait = 0;
    private int aiu = 0;
    private boolean aiv = true;
    private boolean aiw = true;
    private HashMap<String, String> aiB = new HashMap<>();
    private HashMap<String, String> aiC = new HashMap<>();
    private String aiJ = null;
    private String aiK = null;
    private List<b> aiL = new ArrayList();
    private List<a> aiM = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aiN;
        public int aiO;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aiN;
        public int aiO;
        public String aiP;
        public String aiQ;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void yt() {
        HashMap<String, String> yJ = yJ();
        Set<String> keySet = yJ.keySet();
        if (keySet.size() != 1) {
            ew(null);
        } else {
            ew(yJ.get(keySet.iterator().next()));
        }
    }

    public void yu() {
        HashMap<String, String> yP = yP();
        Set<String> keySet = yP.keySet();
        if (keySet.size() != 1) {
            eC(null);
        } else {
            eC(yP.get(keySet.iterator().next()));
        }
    }

    public int yv() {
        return this.aib;
    }

    public void dt(int i) {
        this.aib = i;
    }

    public int yw() {
        return this.aie;
    }

    public void du(int i) {
        this.aie = i;
    }

    public int yx() {
        return this.aif;
    }

    public int yy() {
        return this.aij;
    }

    public void dv(int i) {
        this.aij = i;
    }

    public int yz() {
        return this.ain;
    }

    public void dw(int i) {
        this.ain = i;
    }

    public int yA() {
        return this.aim;
    }

    public void dx(int i) {
        this.aim = i;
    }

    public int yB() {
        return this.aib;
    }

    public int yC() {
        return this.aid;
    }

    public void dy(int i) {
        this.aid = i;
    }

    public boolean yD() {
        return this.aiv;
    }

    public void bb(boolean z) {
        this.aiv = z;
    }

    public String yE() {
        return this.aix;
    }

    public void ev(String str) {
        this.aix = str;
    }

    public String yF() {
        return this.aiD;
    }

    public void ew(String str) {
        this.aiD = str;
    }

    public void ex(String str) {
        this.aiE = str;
    }

    public int yG() {
        return this.aic;
    }

    public void dz(int i) {
        this.aic = i;
    }

    public void ey(String str) {
        this.aiF = str;
    }

    public String yH() {
        return this.aiH;
    }

    public String yI() {
        return this.aiI;
    }

    public HashMap<String, String> yJ() {
        return this.aiB;
    }

    public int yK() {
        return this.aig;
    }

    public void dA(int i) {
        this.aig = i;
    }

    public int yL() {
        return this.aik;
    }

    public void dB(int i) {
        this.aik = i;
    }

    public int yM() {
        return this.aio;
    }

    public void dC(int i) {
        this.aio = i;
    }

    public void ez(String str) {
        this.aiy = str;
    }

    public void eA(String str) {
        this.aiz = str;
    }

    public int yN() {
        return this.ail;
    }

    public void dD(int i) {
        this.ail = i;
    }

    public String yO() {
        return this.aiA;
    }

    public void eB(String str) {
        this.aiA = str;
    }

    public HashMap<String, String> yP() {
        return this.aiC;
    }

    public String yQ() {
        return this.aiG;
    }

    public void eC(String str) {
        this.aiG = str;
    }

    public int yR() {
        return this.aih;
    }

    public int yS() {
        return this.aii;
    }

    public void dE(int i) {
        this.aih = i;
    }

    public void dF(int i) {
        this.aii = i;
    }

    public void eD(String str) {
        this.aiJ = str;
    }

    public void eE(String str) {
        this.aiK = str;
    }

    public int yT() {
        return this.aiq;
    }

    public void dG(int i) {
        this.aiq = i;
    }

    public int yU() {
        return this.air;
    }

    public void dH(int i) {
        this.air = i;
    }

    public int yV() {
        return this.ais;
    }

    public void dI(int i) {
        this.ais = i;
    }

    public int yW() {
        return this.ait;
    }

    public void dJ(int i) {
        this.ait = i;
    }

    public List<b> yX() {
        return this.aiL;
    }

    public List<a> yY() {
        return this.aiM;
    }

    public int yZ() {
        return this.aiu;
    }

    public void dK(int i) {
        this.aiu = i;
    }
}
