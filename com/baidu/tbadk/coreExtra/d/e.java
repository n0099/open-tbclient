package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String akX;
    private String akY;
    private String akZ;
    private String ala;
    private String ald;
    private String ale;
    private String alf;
    private String alg;
    private String alh;
    private String ali;
    private int akB = 0;
    private int akC = 0;
    private int akD = 0;
    private int akE = 0;
    private int akF = 0;
    private int akG = 0;
    private int akH = 0;
    private int akI = 0;
    private int akJ = 0;
    private int akK = 0;
    private int akL = 0;
    private int akM = 0;
    private int akN = 0;
    private int akO = 0;
    private int akP = 0;
    private int akQ = 0;
    private int akR = 0;
    private int akS = 0;
    private int akT = 0;
    private int akU = 0;
    private boolean akV = true;
    private boolean akW = true;
    private HashMap<String, String> alb = new HashMap<>();
    private HashMap<String, String> alc = new HashMap<>();
    private String alj = null;
    private String alk = null;
    private List<b> all = new ArrayList();
    private List<a> alm = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aln;
        public String content;
        public int gid;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aln;
        public String alo;
        public String alp;
        public String content;
        public int gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void yz() {
        HashMap<String, String> yP = yP();
        Set<String> keySet = yP.keySet();
        if (keySet.size() != 1) {
            ep(null);
        } else {
            ep(yP.get(keySet.iterator().next()));
        }
    }

    public void yA() {
        HashMap<String, String> yV = yV();
        Set<String> keySet = yV.keySet();
        if (keySet.size() != 1) {
            ev(null);
        } else {
            ev(yV.get(keySet.iterator().next()));
        }
    }

    public int yB() {
        return this.akB;
    }

    public void dn(int i) {
        this.akB = i;
    }

    public int yC() {
        return this.akE;
    }

    public void dp(int i) {
        this.akE = i;
    }

    public int yD() {
        return this.akF;
    }

    public int yE() {
        return this.akJ;
    }

    public void dq(int i) {
        this.akJ = i;
    }

    public int yF() {
        return this.akN;
    }

    public void dr(int i) {
        this.akN = i;
    }

    public int yG() {
        return this.akM;
    }

    public void ds(int i) {
        this.akM = i;
    }

    public int yH() {
        return this.akB;
    }

    public int yI() {
        return this.akD;
    }

    public void dt(int i) {
        this.akD = i;
    }

    public boolean yJ() {
        return this.akV;
    }

    public void aQ(boolean z) {
        this.akV = z;
    }

    public String yK() {
        return this.akX;
    }

    public void eo(String str) {
        this.akX = str;
    }

    public String yL() {
        return this.ald;
    }

    public void ep(String str) {
        this.ald = str;
    }

    public void eq(String str) {
        this.ale = str;
    }

    public int yM() {
        return this.akC;
    }

    public void du(int i) {
        this.akC = i;
    }

    public void er(String str) {
        this.alf = str;
    }

    public String yN() {
        return this.alh;
    }

    public String yO() {
        return this.ali;
    }

    public HashMap<String, String> yP() {
        return this.alb;
    }

    public int yQ() {
        return this.akG;
    }

    public void dv(int i) {
        this.akG = i;
    }

    public int yR() {
        return this.akK;
    }

    public void dw(int i) {
        this.akK = i;
    }

    public int yS() {
        return this.akO;
    }

    public void dx(int i) {
        this.akO = i;
    }

    public void es(String str) {
        this.akY = str;
    }

    public void et(String str) {
        this.akZ = str;
    }

    public int yT() {
        return this.akL;
    }

    public void dy(int i) {
        this.akL = i;
    }

    public String yU() {
        return this.ala;
    }

    public void eu(String str) {
        this.ala = str;
    }

    public HashMap<String, String> yV() {
        return this.alc;
    }

    public String yW() {
        return this.alg;
    }

    public void ev(String str) {
        this.alg = str;
    }

    public int yX() {
        return this.akH;
    }

    public int yY() {
        return this.akI;
    }

    public void dz(int i) {
        this.akH = i;
    }

    public void dA(int i) {
        this.akI = i;
    }

    public void ew(String str) {
        this.alj = str;
    }

    public void ex(String str) {
        this.alk = str;
    }

    public int yZ() {
        return this.akQ;
    }

    public void dB(int i) {
        this.akQ = i;
    }

    public int za() {
        return this.akR;
    }

    public void dC(int i) {
        this.akR = i;
    }

    public int zb() {
        return this.akS;
    }

    public void dD(int i) {
        this.akS = i;
    }

    public int zc() {
        return this.akT;
    }

    public void dE(int i) {
        this.akT = i;
    }

    public List<b> zd() {
        return this.all;
    }

    public List<a> ze() {
        return this.alm;
    }

    public int zf() {
        return this.akU;
    }

    public void dF(int i) {
        this.akU = i;
    }
}
