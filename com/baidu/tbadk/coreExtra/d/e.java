package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ajm;
    private String ajn;
    private String ajo;
    private String ajp;
    private String ajs;
    private String ajt;
    private String aju;
    private String ajv;
    private String ajw;
    private String ajx;
    private int aiQ = 0;
    private int aiR = 0;
    private int aiS = 0;
    private int aiT = 0;
    private int aiU = 0;
    private int aiV = 0;
    private int aiW = 0;
    private int aiX = 0;
    private int aiY = 0;
    private int aiZ = 0;
    private int aja = 0;
    private int ajb = 0;
    private int ajc = 0;
    private int ajd = 0;
    private int aje = 0;
    private int ajf = 0;
    private int ajg = 0;
    private int ajh = 0;
    private int aji = 0;
    private int ajj = 0;
    private boolean ajk = true;
    private boolean ajl = true;
    private HashMap<String, String> ajq = new HashMap<>();
    private HashMap<String, String> ajr = new HashMap<>();
    private String ajy = null;
    private String ajz = null;
    private List<b> ajA = new ArrayList();
    private List<a> ajB = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int ajC;
        public int ajD;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ajC;
        public int ajD;
        public String ajE;
        public String ajF;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void yt() {
        HashMap<String, String> yJ = yJ();
        Set<String> keySet = yJ.keySet();
        if (keySet.size() != 1) {
            eu(null);
        } else {
            eu(yJ.get(keySet.iterator().next()));
        }
    }

    public void yu() {
        HashMap<String, String> yP = yP();
        Set<String> keySet = yP.keySet();
        if (keySet.size() != 1) {
            eA(null);
        } else {
            eA(yP.get(keySet.iterator().next()));
        }
    }

    public int yv() {
        return this.aiQ;
    }

    public void dt(int i) {
        this.aiQ = i;
    }

    public int yw() {
        return this.aiT;
    }

    public void du(int i) {
        this.aiT = i;
    }

    public int yx() {
        return this.aiU;
    }

    public int yy() {
        return this.aiY;
    }

    public void dv(int i) {
        this.aiY = i;
    }

    public int yz() {
        return this.ajc;
    }

    public void dw(int i) {
        this.ajc = i;
    }

    public int yA() {
        return this.ajb;
    }

    public void dx(int i) {
        this.ajb = i;
    }

    public int yB() {
        return this.aiQ;
    }

    public int yC() {
        return this.aiS;
    }

    public void dy(int i) {
        this.aiS = i;
    }

    public boolean yD() {
        return this.ajk;
    }

    public void be(boolean z) {
        this.ajk = z;
    }

    public String yE() {
        return this.ajm;
    }

    public void et(String str) {
        this.ajm = str;
    }

    public String yF() {
        return this.ajs;
    }

    public void eu(String str) {
        this.ajs = str;
    }

    public void ev(String str) {
        this.ajt = str;
    }

    public int yG() {
        return this.aiR;
    }

    public void dz(int i) {
        this.aiR = i;
    }

    public void ew(String str) {
        this.aju = str;
    }

    public String yH() {
        return this.ajw;
    }

    public String yI() {
        return this.ajx;
    }

    public HashMap<String, String> yJ() {
        return this.ajq;
    }

    public int yK() {
        return this.aiV;
    }

    public void dA(int i) {
        this.aiV = i;
    }

    public int yL() {
        return this.aiZ;
    }

    public void dB(int i) {
        this.aiZ = i;
    }

    public int yM() {
        return this.ajd;
    }

    public void dC(int i) {
        this.ajd = i;
    }

    public void ex(String str) {
        this.ajn = str;
    }

    public void ey(String str) {
        this.ajo = str;
    }

    public int yN() {
        return this.aja;
    }

    public void dD(int i) {
        this.aja = i;
    }

    public String yO() {
        return this.ajp;
    }

    public void ez(String str) {
        this.ajp = str;
    }

    public HashMap<String, String> yP() {
        return this.ajr;
    }

    public String yQ() {
        return this.ajv;
    }

    public void eA(String str) {
        this.ajv = str;
    }

    public int yR() {
        return this.aiW;
    }

    public int yS() {
        return this.aiX;
    }

    public void dE(int i) {
        this.aiW = i;
    }

    public void dF(int i) {
        this.aiX = i;
    }

    public void eB(String str) {
        this.ajy = str;
    }

    public void eC(String str) {
        this.ajz = str;
    }

    public int yT() {
        return this.ajf;
    }

    public void dG(int i) {
        this.ajf = i;
    }

    public int yU() {
        return this.ajg;
    }

    public void dH(int i) {
        this.ajg = i;
    }

    public int yV() {
        return this.ajh;
    }

    public void dI(int i) {
        this.ajh = i;
    }

    public int yW() {
        return this.aji;
    }

    public void dJ(int i) {
        this.aji = i;
    }

    public List<b> yX() {
        return this.ajA;
    }

    public List<a> yY() {
        return this.ajB;
    }

    public int yZ() {
        return this.ajj;
    }

    public void dK(int i) {
        this.ajj = i;
    }
}
