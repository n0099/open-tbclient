package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String caB;
    private String caC;
    private String caD;
    private String caE;
    private String caF;
    private String caG;
    private String cav;
    private String caw;
    private String cax;
    private String cay;
    private int cad = 0;
    private int cae = 0;
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
    private boolean cat = true;
    private boolean cau = true;
    private HashMap<String, String> caz = new HashMap<>();
    private HashMap<String, String> caA = new HashMap<>();
    private List<a> caH = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String caI;
        public String caJ;
        public int caK;
        public String caL;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void aiX() {
        HashMap<String, String> ajn = ajn();
        Set<String> keySet = ajn.keySet();
        if (keySet.size() != 1) {
            nP(null);
        } else {
            nP(ajn.get(keySet.iterator().next()));
        }
    }

    public void aiY() {
        HashMap<String, String> ajt = ajt();
        Set<String> keySet = ajt.keySet();
        if (keySet.size() != 1) {
            nV(null);
        } else {
            nV(ajt.get(keySet.iterator().next()));
        }
    }

    public int aiZ() {
        return this.cad;
    }

    public void iG(int i) {
        this.cad = i;
    }

    public int aja() {
        return this.cag;
    }

    public void iH(int i) {
        this.cag = i;
    }

    public int ajb() {
        return this.cah;
    }

    public int ajc() {
        return this.caj;
    }

    public void iI(int i) {
        this.caj = i;
    }

    public int ajd() {
        return this.can;
    }

    public void iJ(int i) {
        this.can = i;
    }

    public int aje() {
        return this.cam;
    }

    public void iK(int i) {
        this.cam = i;
    }

    public int ajf() {
        return this.cad;
    }

    public int ajg() {
        return this.caf;
    }

    public void iL(int i) {
        this.caf = i;
    }

    public boolean ajh() {
        return this.cat;
    }

    public void eo(boolean z) {
        this.cat = z;
    }

    public String aji() {
        return this.cav;
    }

    public void nO(String str) {
        this.cav = str;
    }

    public String ajj() {
        return this.caB;
    }

    public void nP(String str) {
        this.caB = str;
    }

    public void nQ(String str) {
        this.caC = str;
    }

    public int ajk() {
        return this.cae;
    }

    public void iM(int i) {
        this.cae = i;
    }

    public void nR(String str) {
        this.caD = str;
    }

    public String ajl() {
        return this.caF;
    }

    public String ajm() {
        return this.caG;
    }

    public HashMap<String, String> ajn() {
        return this.caz;
    }

    public int ajo() {
        return this.cai;
    }

    public void iN(int i) {
        this.cai = i;
    }

    public int ajp() {
        return this.cak;
    }

    public void iO(int i) {
        this.cak = i;
    }

    public int ajq() {
        return this.cao;
    }

    public void iP(int i) {
        this.cao = i;
    }

    public void nS(String str) {
        this.caw = str;
    }

    public void nT(String str) {
        this.cax = str;
    }

    public int ajr() {
        return this.cal;
    }

    public void iQ(int i) {
        this.cal = i;
    }

    public String ajs() {
        return this.cay;
    }

    public void nU(String str) {
        this.cay = str;
    }

    public HashMap<String, String> ajt() {
        return this.caA;
    }

    public String aju() {
        return this.caE;
    }

    public void nV(String str) {
        this.caE = str;
    }

    public int ajv() {
        return this.caq;
    }

    public void iR(int i) {
        this.caq = i;
    }

    public int ajw() {
        return this.car;
    }

    public void iS(int i) {
        this.car = i;
    }

    public List<a> ajx() {
        return this.caH;
    }

    public int ajy() {
        return this.cas;
    }

    public void iT(int i) {
        this.cas = i;
    }
}
