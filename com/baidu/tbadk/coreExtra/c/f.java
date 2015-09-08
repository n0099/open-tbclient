package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class f {
    private String ajb;
    private String ajc;
    private String ajd;
    private String aje;
    private String ajh;
    private String aji;
    private String ajj;
    private String ajk;
    private String ajl;
    private String ajm;
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
    private int aiQ = 0;
    private int aiR = 0;
    private int aiS = 0;
    private int aiT = 0;
    private int aiU = 0;
    private int aiV = 0;
    private int aiW = 0;
    private int aiX = 0;
    private int aiY = 0;
    private boolean aiZ = true;
    private boolean aja = true;
    private HashMap<String, String> ajf = new HashMap<>();
    private HashMap<String, String> ajg = new HashMap<>();
    private String ajn = null;
    private String ajo = null;
    private List<b> ajp = new ArrayList();
    private List<a> ajq = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int ajr;
        public String content;
        public int gid;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ajr;
        public String ajs;
        public String ajt;
        public String content;
        public int gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void yf() {
        HashMap<String, String> yv = yv();
        Set<String> keySet = yv.keySet();
        if (keySet.size() != 1) {
            ea(null);
        } else {
            ea(yv.get(keySet.iterator().next()));
        }
    }

    public void yg() {
        HashMap<String, String> yB = yB();
        Set<String> keySet = yB.keySet();
        if (keySet.size() != 1) {
            eg(null);
        } else {
            eg(yB.get(keySet.iterator().next()));
        }
    }

    public int yh() {
        return this.aiF;
    }

    public void dd(int i) {
        this.aiF = i;
    }

    public int yi() {
        return this.aiI;
    }

    public void de(int i) {
        this.aiI = i;
    }

    public int yj() {
        return this.aiJ;
    }

    public int yk() {
        return this.aiN;
    }

    public void df(int i) {
        this.aiN = i;
    }

    public int yl() {
        return this.aiR;
    }

    public void dg(int i) {
        this.aiR = i;
    }

    public int ym() {
        return this.aiQ;
    }

    public void dh(int i) {
        this.aiQ = i;
    }

    public int yn() {
        return this.aiF;
    }

    public int yo() {
        return this.aiH;
    }

    public void di(int i) {
        this.aiH = i;
    }

    public boolean yp() {
        return this.aiZ;
    }

    public void aP(boolean z) {
        this.aiZ = z;
    }

    public String yq() {
        return this.ajb;
    }

    public void dZ(String str) {
        this.ajb = str;
    }

    public String yr() {
        return this.ajh;
    }

    public void ea(String str) {
        this.ajh = str;
    }

    public void eb(String str) {
        this.aji = str;
    }

    public int ys() {
        return this.aiG;
    }

    public void dj(int i) {
        this.aiG = i;
    }

    public void ec(String str) {
        this.ajj = str;
    }

    public String yt() {
        return this.ajl;
    }

    public String yu() {
        return this.ajm;
    }

    public HashMap<String, String> yv() {
        return this.ajf;
    }

    public int yw() {
        return this.aiK;
    }

    public void dk(int i) {
        this.aiK = i;
    }

    public int yx() {
        return this.aiO;
    }

    public void dl(int i) {
        this.aiO = i;
    }

    public int yy() {
        return this.aiS;
    }

    public void dm(int i) {
        this.aiS = i;
    }

    public void ed(String str) {
        this.ajc = str;
    }

    public void ee(String str) {
        this.ajd = str;
    }

    public int yz() {
        return this.aiP;
    }

    public void dn(int i) {
        this.aiP = i;
    }

    public String yA() {
        return this.aje;
    }

    public void ef(String str) {
        this.aje = str;
    }

    public HashMap<String, String> yB() {
        return this.ajg;
    }

    public String yC() {
        return this.ajk;
    }

    public void eg(String str) {
        this.ajk = str;
    }

    public int yD() {
        return this.aiL;
    }

    public int yE() {
        return this.aiM;
    }

    public void dp(int i) {
        this.aiL = i;
    }

    public void dq(int i) {
        this.aiM = i;
    }

    public void eh(String str) {
        this.ajn = str;
    }

    public void ei(String str) {
        this.ajo = str;
    }

    public int yF() {
        return this.aiU;
    }

    public void dr(int i) {
        this.aiU = i;
    }

    public int yG() {
        return this.aiV;
    }

    public void ds(int i) {
        this.aiV = i;
    }

    public int yH() {
        return this.aiW;
    }

    public void dt(int i) {
        this.aiW = i;
    }

    public int yI() {
        return this.aiX;
    }

    public void du(int i) {
        this.aiX = i;
    }

    public List<b> yJ() {
        return this.ajp;
    }

    public List<a> yK() {
        return this.ajq;
    }

    public int yL() {
        return this.aiY;
    }

    public void dv(int i) {
        this.aiY = i;
    }
}
