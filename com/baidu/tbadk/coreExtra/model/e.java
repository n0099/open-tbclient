package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String caA;
    private String caB;
    private String caE;
    private String caF;
    private String caG;
    private String caH;
    private String caI;
    private String caJ;
    private String cay;
    private String caz;
    private int cag = 0;
    private int cah = 0;
    private int cai = 0;
    private int caj = 0;
    private int cak = 0;
    private int cal = 0;
    private int cam = 0;
    private int can = 0;
    private int cao = 0;
    private int cap = 0;
    private int caq = 0;
    private int car = 0;
    private int cas = 0;
    private int cat = 0;
    private int cau = 0;
    private int cav = 0;
    private boolean caw = true;
    private boolean cax = true;
    private HashMap<String, String> caC = new HashMap<>();
    private HashMap<String, String> caD = new HashMap<>();
    private List<a> caK = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String caL;
        public String caM;
        public int caN;
        public String caO;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void aiT() {
        HashMap<String, String> ajj = ajj();
        Set<String> keySet = ajj.keySet();
        if (keySet.size() != 1) {
            nQ(null);
        } else {
            nQ(ajj.get(keySet.iterator().next()));
        }
    }

    public void aiU() {
        HashMap<String, String> ajp = ajp();
        Set<String> keySet = ajp.keySet();
        if (keySet.size() != 1) {
            nW(null);
        } else {
            nW(ajp.get(keySet.iterator().next()));
        }
    }

    public int aiV() {
        return this.cag;
    }

    public void iF(int i) {
        this.cag = i;
    }

    public int aiW() {
        return this.caj;
    }

    public void iG(int i) {
        this.caj = i;
    }

    public int aiX() {
        return this.cak;
    }

    public int aiY() {
        return this.cam;
    }

    public void iH(int i) {
        this.cam = i;
    }

    public int aiZ() {
        return this.caq;
    }

    public void iI(int i) {
        this.caq = i;
    }

    public int aja() {
        return this.cap;
    }

    public void iJ(int i) {
        this.cap = i;
    }

    public int ajb() {
        return this.cag;
    }

    public int ajc() {
        return this.cai;
    }

    public void iK(int i) {
        this.cai = i;
    }

    public boolean ajd() {
        return this.caw;
    }

    public void eo(boolean z) {
        this.caw = z;
    }

    public String aje() {
        return this.cay;
    }

    public void nP(String str) {
        this.cay = str;
    }

    public String ajf() {
        return this.caE;
    }

    public void nQ(String str) {
        this.caE = str;
    }

    public void nR(String str) {
        this.caF = str;
    }

    public int ajg() {
        return this.cah;
    }

    public void iL(int i) {
        this.cah = i;
    }

    public void nS(String str) {
        this.caG = str;
    }

    public String ajh() {
        return this.caI;
    }

    public String aji() {
        return this.caJ;
    }

    public HashMap<String, String> ajj() {
        return this.caC;
    }

    public int ajk() {
        return this.cal;
    }

    public void iM(int i) {
        this.cal = i;
    }

    public int ajl() {
        return this.can;
    }

    public void iN(int i) {
        this.can = i;
    }

    public int ajm() {
        return this.car;
    }

    public void iO(int i) {
        this.car = i;
    }

    public void nT(String str) {
        this.caz = str;
    }

    public void nU(String str) {
        this.caA = str;
    }

    public int ajn() {
        return this.cao;
    }

    public void iP(int i) {
        this.cao = i;
    }

    public String ajo() {
        return this.caB;
    }

    public void nV(String str) {
        this.caB = str;
    }

    public HashMap<String, String> ajp() {
        return this.caD;
    }

    public String ajq() {
        return this.caH;
    }

    public void nW(String str) {
        this.caH = str;
    }

    public int ajr() {
        return this.cat;
    }

    public void iQ(int i) {
        this.cat = i;
    }

    public int ajs() {
        return this.cau;
    }

    public void iR(int i) {
        this.cau = i;
    }

    public List<a> ajt() {
        return this.caK;
    }

    public int aju() {
        return this.cav;
    }

    public void iS(int i) {
        this.cav = i;
    }
}
