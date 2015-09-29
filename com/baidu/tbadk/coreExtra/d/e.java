package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ahX;
    private String ahY;
    private String ahZ;
    private String aia;
    private String aid;
    private String aie;
    private String aif;
    private String aig;
    private String aih;
    private String aii;
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
    private int ahP = 0;
    private int ahQ = 0;
    private int ahR = 0;
    private int ahS = 0;
    private int ahT = 0;
    private int ahU = 0;
    private boolean ahV = true;
    private boolean ahW = true;
    private HashMap<String, String> aib = new HashMap<>();
    private HashMap<String, String> aic = new HashMap<>();
    private String aij = null;
    private String aik = null;
    private List<b> ail = new ArrayList();
    private List<a> aim = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int ain;
        public String content;
        public int gid;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ain;
        public String aio;
        public String aip;
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
        return this.ahB;
    }

    public void de(int i) {
        this.ahB = i;
    }

    public int xS() {
        return this.ahE;
    }

    public void df(int i) {
        this.ahE = i;
    }

    public int xT() {
        return this.ahF;
    }

    public int xU() {
        return this.ahJ;
    }

    public void dg(int i) {
        this.ahJ = i;
    }

    public int xV() {
        return this.ahN;
    }

    public void dh(int i) {
        this.ahN = i;
    }

    public int xW() {
        return this.ahM;
    }

    public void di(int i) {
        this.ahM = i;
    }

    public int xX() {
        return this.ahB;
    }

    public int xY() {
        return this.ahD;
    }

    public void dj(int i) {
        this.ahD = i;
    }

    public boolean xZ() {
        return this.ahV;
    }

    public void aO(boolean z) {
        this.ahV = z;
    }

    public String ya() {
        return this.ahX;
    }

    public void ec(String str) {
        this.ahX = str;
    }

    public String yb() {
        return this.aid;
    }

    public void ed(String str) {
        this.aid = str;
    }

    public void ee(String str) {
        this.aie = str;
    }

    public int yc() {
        return this.ahC;
    }

    public void dk(int i) {
        this.ahC = i;
    }

    public void ef(String str) {
        this.aif = str;
    }

    public String yd() {
        return this.aih;
    }

    public String ye() {
        return this.aii;
    }

    public HashMap<String, String> yf() {
        return this.aib;
    }

    public int yg() {
        return this.ahG;
    }

    public void dl(int i) {
        this.ahG = i;
    }

    public int yh() {
        return this.ahK;
    }

    public void dm(int i) {
        this.ahK = i;
    }

    public int yi() {
        return this.ahO;
    }

    public void dn(int i) {
        this.ahO = i;
    }

    public void eg(String str) {
        this.ahY = str;
    }

    public void eh(String str) {
        this.ahZ = str;
    }

    public int yj() {
        return this.ahL;
    }

    public void dp(int i) {
        this.ahL = i;
    }

    public String yk() {
        return this.aia;
    }

    public void ei(String str) {
        this.aia = str;
    }

    public HashMap<String, String> yl() {
        return this.aic;
    }

    public String ym() {
        return this.aig;
    }

    public void ej(String str) {
        this.aig = str;
    }

    public int yn() {
        return this.ahH;
    }

    public int yo() {
        return this.ahI;
    }

    public void dq(int i) {
        this.ahH = i;
    }

    public void dr(int i) {
        this.ahI = i;
    }

    public void ek(String str) {
        this.aij = str;
    }

    public void el(String str) {
        this.aik = str;
    }

    public int yp() {
        return this.ahQ;
    }

    public void ds(int i) {
        this.ahQ = i;
    }

    public int yq() {
        return this.ahR;
    }

    public void dt(int i) {
        this.ahR = i;
    }

    public int yr() {
        return this.ahS;
    }

    public void du(int i) {
        this.ahS = i;
    }

    public int ys() {
        return this.ahT;
    }

    public void dv(int i) {
        this.ahT = i;
    }

    public List<b> yt() {
        return this.ail;
    }

    public List<a> yu() {
        return this.aim;
    }

    public int yv() {
        return this.ahU;
    }

    public void dw(int i) {
        this.ahU = i;
    }
}
