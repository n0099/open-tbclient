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

    public void yn() {
        HashMap<String, String> yD = yD();
        Set<String> keySet = yD.keySet();
        if (keySet.size() != 1) {
            es(null);
        } else {
            es(yD.get(keySet.iterator().next()));
        }
    }

    public void yo() {
        HashMap<String, String> yJ = yJ();
        Set<String> keySet = yJ.keySet();
        if (keySet.size() != 1) {
            ey(null);
        } else {
            ey(yJ.get(keySet.iterator().next()));
        }
    }

    public int yp() {
        return this.ahv;
    }

    public void ds(int i) {
        this.ahv = i;
    }

    public int yq() {
        return this.ahy;
    }

    public void dt(int i) {
        this.ahy = i;
    }

    public int yr() {
        return this.ahz;
    }

    public int ys() {
        return this.ahD;
    }

    public void du(int i) {
        this.ahD = i;
    }

    public int yt() {
        return this.ahH;
    }

    public void dv(int i) {
        this.ahH = i;
    }

    public int yu() {
        return this.ahG;
    }

    public void dw(int i) {
        this.ahG = i;
    }

    public int yv() {
        return this.ahv;
    }

    public int yw() {
        return this.ahx;
    }

    public void dx(int i) {
        this.ahx = i;
    }

    public boolean yx() {
        return this.ahP;
    }

    public void be(boolean z) {
        this.ahP = z;
    }

    public String yy() {
        return this.ahR;
    }

    public void er(String str) {
        this.ahR = str;
    }

    public String yz() {
        return this.ahX;
    }

    public void es(String str) {
        this.ahX = str;
    }

    public void et(String str) {
        this.ahY = str;
    }

    public int yA() {
        return this.ahw;
    }

    public void dy(int i) {
        this.ahw = i;
    }

    public void eu(String str) {
        this.ahZ = str;
    }

    public String yB() {
        return this.aib;
    }

    public String yC() {
        return this.aic;
    }

    public HashMap<String, String> yD() {
        return this.ahV;
    }

    public int yE() {
        return this.ahA;
    }

    public void dz(int i) {
        this.ahA = i;
    }

    public int yF() {
        return this.ahE;
    }

    public void dA(int i) {
        this.ahE = i;
    }

    public int yG() {
        return this.ahI;
    }

    public void dB(int i) {
        this.ahI = i;
    }

    public void ev(String str) {
        this.ahS = str;
    }

    public void ew(String str) {
        this.ahT = str;
    }

    public int yH() {
        return this.ahF;
    }

    public void dC(int i) {
        this.ahF = i;
    }

    public String yI() {
        return this.ahU;
    }

    public void ex(String str) {
        this.ahU = str;
    }

    public HashMap<String, String> yJ() {
        return this.ahW;
    }

    public String yK() {
        return this.aia;
    }

    public void ey(String str) {
        this.aia = str;
    }

    public int yL() {
        return this.ahB;
    }

    public int yM() {
        return this.ahC;
    }

    public void dD(int i) {
        this.ahB = i;
    }

    public void dE(int i) {
        this.ahC = i;
    }

    public void ez(String str) {
        this.aid = str;
    }

    public void eA(String str) {
        this.aie = str;
    }

    public int yN() {
        return this.ahK;
    }

    public void dF(int i) {
        this.ahK = i;
    }

    public int yO() {
        return this.ahL;
    }

    public void dG(int i) {
        this.ahL = i;
    }

    public int yP() {
        return this.ahM;
    }

    public void dH(int i) {
        this.ahM = i;
    }

    public int yQ() {
        return this.ahN;
    }

    public void dI(int i) {
        this.ahN = i;
    }

    public List<b> yR() {
        return this.aif;
    }

    public List<a> yS() {
        return this.aig;
    }

    public int yT() {
        return this.ahO;
    }

    public void dJ(int i) {
        this.ahO = i;
    }
}
