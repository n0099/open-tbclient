package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String caA;
    private String caD;
    private String caE;
    private String caF;
    private String caG;
    private String caH;
    private String caI;
    private String cax;
    private String cay;
    private String caz;
    private int caf = 0;
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
    private boolean cav = true;
    private boolean caw = true;
    private HashMap<String, String> caB = new HashMap<>();
    private HashMap<String, String> caC = new HashMap<>();
    private List<a> caJ = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String caK;
        public String caL;
        public int caM;
        public String caN;
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
        return this.caf;
    }

    public void iF(int i) {
        this.caf = i;
    }

    public int aiW() {
        return this.cai;
    }

    public void iG(int i) {
        this.cai = i;
    }

    public int aiX() {
        return this.caj;
    }

    public int aiY() {
        return this.cal;
    }

    public void iH(int i) {
        this.cal = i;
    }

    public int aiZ() {
        return this.cap;
    }

    public void iI(int i) {
        this.cap = i;
    }

    public int aja() {
        return this.cao;
    }

    public void iJ(int i) {
        this.cao = i;
    }

    public int ajb() {
        return this.caf;
    }

    public int ajc() {
        return this.cah;
    }

    public void iK(int i) {
        this.cah = i;
    }

    public boolean ajd() {
        return this.cav;
    }

    public void eo(boolean z) {
        this.cav = z;
    }

    public String aje() {
        return this.cax;
    }

    public void nP(String str) {
        this.cax = str;
    }

    public String ajf() {
        return this.caD;
    }

    public void nQ(String str) {
        this.caD = str;
    }

    public void nR(String str) {
        this.caE = str;
    }

    public int ajg() {
        return this.cag;
    }

    public void iL(int i) {
        this.cag = i;
    }

    public void nS(String str) {
        this.caF = str;
    }

    public String ajh() {
        return this.caH;
    }

    public String aji() {
        return this.caI;
    }

    public HashMap<String, String> ajj() {
        return this.caB;
    }

    public int ajk() {
        return this.cak;
    }

    public void iM(int i) {
        this.cak = i;
    }

    public int ajl() {
        return this.cam;
    }

    public void iN(int i) {
        this.cam = i;
    }

    public int ajm() {
        return this.caq;
    }

    public void iO(int i) {
        this.caq = i;
    }

    public void nT(String str) {
        this.cay = str;
    }

    public void nU(String str) {
        this.caz = str;
    }

    public int ajn() {
        return this.can;
    }

    public void iP(int i) {
        this.can = i;
    }

    public String ajo() {
        return this.caA;
    }

    public void nV(String str) {
        this.caA = str;
    }

    public HashMap<String, String> ajp() {
        return this.caC;
    }

    public String ajq() {
        return this.caG;
    }

    public void nW(String str) {
        this.caG = str;
    }

    public int ajr() {
        return this.cas;
    }

    public void iQ(int i) {
        this.cas = i;
    }

    public int ajs() {
        return this.cat;
    }

    public void iR(int i) {
        this.cat = i;
    }

    public List<a> ajt() {
        return this.caJ;
    }

    public int aju() {
        return this.cau;
    }

    public void iS(int i) {
        this.cau = i;
    }
}
