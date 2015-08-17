package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class f {
    private String aiS;
    private String aiT;
    private String aiU;
    private String aiV;
    private String aiY;
    private String aiZ;
    private String aja;
    private String ajb;
    private String ajc;
    private String ajd;
    private int aiw = 0;
    private int aix = 0;
    private int aiy = 0;
    private int aiz = 0;
    private int aiA = 0;
    private int aiB = 0;
    private int aiC = 0;
    private int aiD = 0;
    private int aiE = 0;
    private int aiF = 0;
    private int aiG = 0;
    private int aiH = 0;
    private int aiI = 0;
    private int aiJ = 0;
    private int aiK = 0;
    private int aiL = 0;
    private int aiM = 0;
    private int aiN = 0;
    private int aiO = 0;
    private int aiP = 0;
    private boolean aiQ = true;
    private boolean aiR = true;
    private HashMap<String, String> aiW = new HashMap<>();
    private HashMap<String, String> aiX = new HashMap<>();
    private String aje = null;
    private String ajf = null;
    private List<b> ajg = new ArrayList();
    private List<a> ajh = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aji;
        public String content;
        public int gid;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aji;
        public String ajj;
        public String ajk;
        public String content;
        public int gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void xY() {
        HashMap<String, String> yo = yo();
        Set<String> keySet = yo.keySet();
        if (keySet.size() != 1) {
            dT(null);
        } else {
            dT(yo.get(keySet.iterator().next()));
        }
    }

    public void xZ() {
        HashMap<String, String> yu = yu();
        Set<String> keySet = yu.keySet();
        if (keySet.size() != 1) {
            dZ(null);
        } else {
            dZ(yu.get(keySet.iterator().next()));
        }
    }

    public int ya() {
        return this.aiw;
    }

    public void cX(int i) {
        this.aiw = i;
    }

    public int yb() {
        return this.aiz;
    }

    public void cY(int i) {
        this.aiz = i;
    }

    public int yc() {
        return this.aiA;
    }

    public int yd() {
        return this.aiE;
    }

    public void cZ(int i) {
        this.aiE = i;
    }

    public int ye() {
        return this.aiI;
    }

    public void da(int i) {
        this.aiI = i;
    }

    public int yf() {
        return this.aiH;
    }

    public void db(int i) {
        this.aiH = i;
    }

    public int yg() {
        return this.aiw;
    }

    public int yh() {
        return this.aiy;
    }

    public void dc(int i) {
        this.aiy = i;
    }

    public boolean yi() {
        return this.aiQ;
    }

    public void aO(boolean z) {
        this.aiQ = z;
    }

    public String yj() {
        return this.aiS;
    }

    public void dS(String str) {
        this.aiS = str;
    }

    public String yk() {
        return this.aiY;
    }

    public void dT(String str) {
        this.aiY = str;
    }

    public void dU(String str) {
        this.aiZ = str;
    }

    public int yl() {
        return this.aix;
    }

    public void dd(int i) {
        this.aix = i;
    }

    public void dV(String str) {
        this.aja = str;
    }

    public String ym() {
        return this.ajc;
    }

    public String yn() {
        return this.ajd;
    }

    public HashMap<String, String> yo() {
        return this.aiW;
    }

    public int yp() {
        return this.aiB;
    }

    public void de(int i) {
        this.aiB = i;
    }

    public int yq() {
        return this.aiF;
    }

    public void df(int i) {
        this.aiF = i;
    }

    public int yr() {
        return this.aiJ;
    }

    public void dg(int i) {
        this.aiJ = i;
    }

    public void dW(String str) {
        this.aiT = str;
    }

    public void dX(String str) {
        this.aiU = str;
    }

    public int ys() {
        return this.aiG;
    }

    public void dh(int i) {
        this.aiG = i;
    }

    public String yt() {
        return this.aiV;
    }

    public void dY(String str) {
        this.aiV = str;
    }

    public HashMap<String, String> yu() {
        return this.aiX;
    }

    public String yv() {
        return this.ajb;
    }

    public void dZ(String str) {
        this.ajb = str;
    }

    public int yw() {
        return this.aiC;
    }

    public int yx() {
        return this.aiD;
    }

    public void di(int i) {
        this.aiC = i;
    }

    public void dj(int i) {
        this.aiD = i;
    }

    public void ea(String str) {
        this.aje = str;
    }

    public void eb(String str) {
        this.ajf = str;
    }

    public int yy() {
        return this.aiL;
    }

    public void dk(int i) {
        this.aiL = i;
    }

    public int yz() {
        return this.aiM;
    }

    public void dl(int i) {
        this.aiM = i;
    }

    public int yA() {
        return this.aiN;
    }

    public void dm(int i) {
        this.aiN = i;
    }

    public int yB() {
        return this.aiO;
    }

    public void dn(int i) {
        this.aiO = i;
    }

    public List<b> yC() {
        return this.ajg;
    }

    public List<a> yD() {
        return this.ajh;
    }

    public int yE() {
        return this.aiP;
    }

    public void dp(int i) {
        this.aiP = i;
    }
}
