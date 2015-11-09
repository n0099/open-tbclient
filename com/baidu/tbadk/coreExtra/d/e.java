package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aie;
    private String aif;
    private String aig;
    private String aih;
    private String aik;
    private String ail;
    private String aim;
    private String ain;
    private String aio;
    private String aip;
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
    private int ahW = 0;
    private int ahX = 0;
    private int ahY = 0;
    private int ahZ = 0;
    private int aia = 0;
    private int aib = 0;
    private boolean aic = true;
    private boolean aid = true;
    private HashMap<String, String> aii = new HashMap<>();
    private HashMap<String, String> aij = new HashMap<>();
    private String aiq = null;
    private String air = null;
    private List<b> ais = new ArrayList();
    private List<a> ait = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aiu;
        public String content;
        public int gid;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aiu;
        public String aiv;
        public String aiw;
        public String content;
        public int gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void xR() {
        HashMap<String, String> yh = yh();
        Set<String> keySet = yh.keySet();
        if (keySet.size() != 1) {
            ed(null);
        } else {
            ed(yh.get(keySet.iterator().next()));
        }
    }

    public void xS() {
        HashMap<String, String> yn = yn();
        Set<String> keySet = yn.keySet();
        if (keySet.size() != 1) {
            ej(null);
        } else {
            ej(yn.get(keySet.iterator().next()));
        }
    }

    public int xT() {
        return this.ahI;
    }

    public void de(int i) {
        this.ahI = i;
    }

    public int xU() {
        return this.ahL;
    }

    public void df(int i) {
        this.ahL = i;
    }

    public int xV() {
        return this.ahM;
    }

    public int xW() {
        return this.ahQ;
    }

    public void dg(int i) {
        this.ahQ = i;
    }

    public int xX() {
        return this.ahU;
    }

    public void dh(int i) {
        this.ahU = i;
    }

    public int xY() {
        return this.ahT;
    }

    public void di(int i) {
        this.ahT = i;
    }

    public int xZ() {
        return this.ahI;
    }

    public int ya() {
        return this.ahK;
    }

    public void dj(int i) {
        this.ahK = i;
    }

    public boolean yb() {
        return this.aic;
    }

    public void aO(boolean z) {
        this.aic = z;
    }

    public String yc() {
        return this.aie;
    }

    public void ec(String str) {
        this.aie = str;
    }

    public String yd() {
        return this.aik;
    }

    public void ed(String str) {
        this.aik = str;
    }

    public void ee(String str) {
        this.ail = str;
    }

    public int ye() {
        return this.ahJ;
    }

    public void dk(int i) {
        this.ahJ = i;
    }

    public void ef(String str) {
        this.aim = str;
    }

    public String yf() {
        return this.aio;
    }

    public String yg() {
        return this.aip;
    }

    public HashMap<String, String> yh() {
        return this.aii;
    }

    public int yi() {
        return this.ahN;
    }

    public void dl(int i) {
        this.ahN = i;
    }

    public int yj() {
        return this.ahR;
    }

    public void dm(int i) {
        this.ahR = i;
    }

    public int yk() {
        return this.ahV;
    }

    public void dn(int i) {
        this.ahV = i;
    }

    public void eg(String str) {
        this.aif = str;
    }

    public void eh(String str) {
        this.aig = str;
    }

    public int yl() {
        return this.ahS;
    }

    public void dp(int i) {
        this.ahS = i;
    }

    public String ym() {
        return this.aih;
    }

    public void ei(String str) {
        this.aih = str;
    }

    public HashMap<String, String> yn() {
        return this.aij;
    }

    public String yo() {
        return this.ain;
    }

    public void ej(String str) {
        this.ain = str;
    }

    public int yp() {
        return this.ahO;
    }

    public int yq() {
        return this.ahP;
    }

    public void dq(int i) {
        this.ahO = i;
    }

    public void dr(int i) {
        this.ahP = i;
    }

    public void ek(String str) {
        this.aiq = str;
    }

    public void el(String str) {
        this.air = str;
    }

    public int yr() {
        return this.ahX;
    }

    public void ds(int i) {
        this.ahX = i;
    }

    public int ys() {
        return this.ahY;
    }

    public void dt(int i) {
        this.ahY = i;
    }

    public int yt() {
        return this.ahZ;
    }

    public void du(int i) {
        this.ahZ = i;
    }

    public int yu() {
        return this.aia;
    }

    public void dv(int i) {
        this.aia = i;
    }

    public List<b> yv() {
        return this.ais;
    }

    public List<a> yw() {
        return this.ait;
    }

    public int yx() {
        return this.aib;
    }

    public void dw(int i) {
        this.aib = i;
    }
}
