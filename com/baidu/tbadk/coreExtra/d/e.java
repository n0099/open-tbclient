package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ahY;
    private String ahZ;
    private String aia;
    private String aib;
    private String aie;
    private String aif;
    private String aig;
    private String aih;
    private String aii;
    private String aij;
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
    private int ahP = 0;
    private int ahQ = 0;
    private int ahR = 0;
    private int ahS = 0;
    private int ahT = 0;
    private int ahU = 0;
    private int ahV = 0;
    private boolean ahW = true;
    private boolean ahX = true;
    private HashMap<String, String> aic = new HashMap<>();
    private HashMap<String, String> aid = new HashMap<>();
    private String aik = null;
    private String ail = null;
    private List<b> aim = new ArrayList();
    private List<a> ain = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aio;
        public String content;
        public int gid;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aio;
        public String aip;
        public String aiq;
        public String content;
        public int gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void xP() {
        HashMap<String, String> yf = yf();
        Set<String> keySet = yf.keySet();
        if (keySet.size() != 1) {
            ed(null);
        } else {
            ed(yf.get(keySet.iterator().next()));
        }
    }

    public void xQ() {
        HashMap<String, String> yl = yl();
        Set<String> keySet = yl.keySet();
        if (keySet.size() != 1) {
            ej(null);
        } else {
            ej(yl.get(keySet.iterator().next()));
        }
    }

    public int xR() {
        return this.ahC;
    }

    public void de(int i) {
        this.ahC = i;
    }

    public int xS() {
        return this.ahF;
    }

    public void df(int i) {
        this.ahF = i;
    }

    public int xT() {
        return this.ahG;
    }

    public int xU() {
        return this.ahK;
    }

    public void dg(int i) {
        this.ahK = i;
    }

    public int xV() {
        return this.ahO;
    }

    public void dh(int i) {
        this.ahO = i;
    }

    public int xW() {
        return this.ahN;
    }

    public void di(int i) {
        this.ahN = i;
    }

    public int xX() {
        return this.ahC;
    }

    public int xY() {
        return this.ahE;
    }

    public void dj(int i) {
        this.ahE = i;
    }

    public boolean xZ() {
        return this.ahW;
    }

    public void aO(boolean z) {
        this.ahW = z;
    }

    public String ya() {
        return this.ahY;
    }

    public void ec(String str) {
        this.ahY = str;
    }

    public String yb() {
        return this.aie;
    }

    public void ed(String str) {
        this.aie = str;
    }

    public void ee(String str) {
        this.aif = str;
    }

    public int yc() {
        return this.ahD;
    }

    public void dk(int i) {
        this.ahD = i;
    }

    public void ef(String str) {
        this.aig = str;
    }

    public String yd() {
        return this.aii;
    }

    public String ye() {
        return this.aij;
    }

    public HashMap<String, String> yf() {
        return this.aic;
    }

    public int yg() {
        return this.ahH;
    }

    public void dl(int i) {
        this.ahH = i;
    }

    public int yh() {
        return this.ahL;
    }

    public void dm(int i) {
        this.ahL = i;
    }

    public int yi() {
        return this.ahP;
    }

    public void dn(int i) {
        this.ahP = i;
    }

    public void eg(String str) {
        this.ahZ = str;
    }

    public void eh(String str) {
        this.aia = str;
    }

    public int yj() {
        return this.ahM;
    }

    public void dp(int i) {
        this.ahM = i;
    }

    public String yk() {
        return this.aib;
    }

    public void ei(String str) {
        this.aib = str;
    }

    public HashMap<String, String> yl() {
        return this.aid;
    }

    public String ym() {
        return this.aih;
    }

    public void ej(String str) {
        this.aih = str;
    }

    public int yn() {
        return this.ahI;
    }

    public int yo() {
        return this.ahJ;
    }

    public void dq(int i) {
        this.ahI = i;
    }

    public void dr(int i) {
        this.ahJ = i;
    }

    public void ek(String str) {
        this.aik = str;
    }

    public void el(String str) {
        this.ail = str;
    }

    public int yp() {
        return this.ahR;
    }

    public void ds(int i) {
        this.ahR = i;
    }

    public int yq() {
        return this.ahS;
    }

    public void dt(int i) {
        this.ahS = i;
    }

    public int yr() {
        return this.ahT;
    }

    public void du(int i) {
        this.ahT = i;
    }

    public int ys() {
        return this.ahU;
    }

    public void dv(int i) {
        this.ahU = i;
    }

    public List<b> yt() {
        return this.aim;
    }

    public List<a> yu() {
        return this.ain;
    }

    public int yv() {
        return this.ahV;
    }

    public void dw(int i) {
        this.ahV = i;
    }
}
