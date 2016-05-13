package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ahR;
    private String ahS;
    private String ahT;
    private String ahU;
    private String ahX;
    private String ahY;
    private String ahZ;
    private String aia;
    private String aib;
    private String aic;
    private int ahv = 0;
    private int ahw = 0;
    private int ahx = 0;
    private int ahy = 0;
    private int ahz = 0;
    private int ahA = 0;
    private int ahB = 0;
    private int ahC = 0;
    private int ahD = 0;
    private int ahE = 0;
    private int ahF = 0;
    private int ahG = 0;
    private int ahH = 0;
    private int ahI = 0;
    private int ahJ = 0;
    private int ahK = 0;
    private int ahL = 0;
    private int ahM = 0;
    private int ahN = 0;
    private int ahO = 0;
    private boolean ahP = true;
    private boolean ahQ = true;
    private HashMap<String, String> ahV = new HashMap<>();
    private HashMap<String, String> ahW = new HashMap<>();
    private String aid = null;
    private String aie = null;
    private List<b> aif = new ArrayList();
    private List<a> aig = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aih;
        public int aii;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aih;
        public int aii;
        public String aij;
        public String aik;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void yo() {
        HashMap<String, String> yE = yE();
        Set<String> keySet = yE.keySet();
        if (keySet.size() != 1) {
            es(null);
        } else {
            es(yE.get(keySet.iterator().next()));
        }
    }

    public void yp() {
        HashMap<String, String> yK = yK();
        Set<String> keySet = yK.keySet();
        if (keySet.size() != 1) {
            ey(null);
        } else {
            ey(yK.get(keySet.iterator().next()));
        }
    }

    public int yq() {
        return this.ahv;
    }

    public void dr(int i) {
        this.ahv = i;
    }

    public int yr() {
        return this.ahy;
    }

    public void ds(int i) {
        this.ahy = i;
    }

    public int ys() {
        return this.ahz;
    }

    public int yt() {
        return this.ahD;
    }

    public void dt(int i) {
        this.ahD = i;
    }

    public int yu() {
        return this.ahH;
    }

    public void du(int i) {
        this.ahH = i;
    }

    public int yv() {
        return this.ahG;
    }

    public void dv(int i) {
        this.ahG = i;
    }

    public int yw() {
        return this.ahv;
    }

    public int yx() {
        return this.ahx;
    }

    public void dw(int i) {
        this.ahx = i;
    }

    public boolean yy() {
        return this.ahP;
    }

    public void be(boolean z) {
        this.ahP = z;
    }

    public String yz() {
        return this.ahR;
    }

    public void er(String str) {
        this.ahR = str;
    }

    public String yA() {
        return this.ahX;
    }

    public void es(String str) {
        this.ahX = str;
    }

    public void et(String str) {
        this.ahY = str;
    }

    public int yB() {
        return this.ahw;
    }

    public void dx(int i) {
        this.ahw = i;
    }

    public void eu(String str) {
        this.ahZ = str;
    }

    public String yC() {
        return this.aib;
    }

    public String yD() {
        return this.aic;
    }

    public HashMap<String, String> yE() {
        return this.ahV;
    }

    public int yF() {
        return this.ahA;
    }

    public void dy(int i) {
        this.ahA = i;
    }

    public int yG() {
        return this.ahE;
    }

    public void dz(int i) {
        this.ahE = i;
    }

    public int yH() {
        return this.ahI;
    }

    public void dA(int i) {
        this.ahI = i;
    }

    public void ev(String str) {
        this.ahS = str;
    }

    public void ew(String str) {
        this.ahT = str;
    }

    public int yI() {
        return this.ahF;
    }

    public void dB(int i) {
        this.ahF = i;
    }

    public String yJ() {
        return this.ahU;
    }

    public void ex(String str) {
        this.ahU = str;
    }

    public HashMap<String, String> yK() {
        return this.ahW;
    }

    public String yL() {
        return this.aia;
    }

    public void ey(String str) {
        this.aia = str;
    }

    public int yM() {
        return this.ahB;
    }

    public int yN() {
        return this.ahC;
    }

    public void dC(int i) {
        this.ahB = i;
    }

    public void dD(int i) {
        this.ahC = i;
    }

    public void ez(String str) {
        this.aid = str;
    }

    public void eA(String str) {
        this.aie = str;
    }

    public int yO() {
        return this.ahK;
    }

    public void dE(int i) {
        this.ahK = i;
    }

    public int yP() {
        return this.ahL;
    }

    public void dF(int i) {
        this.ahL = i;
    }

    public int yQ() {
        return this.ahM;
    }

    public void dG(int i) {
        this.ahM = i;
    }

    public int yR() {
        return this.ahN;
    }

    public void dH(int i) {
        this.ahN = i;
    }

    public List<b> yS() {
        return this.aif;
    }

    public List<a> yT() {
        return this.aig;
    }

    public int yU() {
        return this.ahO;
    }

    public void dI(int i) {
        this.ahO = i;
    }
}
