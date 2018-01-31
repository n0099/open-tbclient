package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String bio;
    private String bip;
    private String biq;
    private String bir;
    private String biu;
    private String biv;
    private String biw;
    private String bix;
    private String biy;
    private String biz;
    private int bhQ = 0;
    private int bhR = 0;
    private int bhS = 0;
    private int bhT = 0;
    private int bhU = 0;
    private int bhV = 0;
    private int bhW = 0;
    private int bhX = 0;
    private int bhY = 0;
    private int bhZ = 0;
    private int bia = 0;
    private int bib = 0;
    private int bic = 0;
    private int bie = 0;
    private int bif = 0;
    private int bih = 0;
    private int bii = 0;
    private int bij = 0;
    private int bik = 0;
    private int bil = 0;
    private boolean bim = true;
    private boolean bin = true;
    private HashMap<String, String> bis = new HashMap<>();
    private HashMap<String, String> bit = new HashMap<>();
    private String biA = null;
    private String biB = null;
    private List<b> biC = new ArrayList();
    private List<a> biD = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int biE;
        public int biF;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int biE;
        public int biF;
        public String biG;
        public String biH;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Hq() {
        HashMap<String, String> HG = HG();
        Set<String> keySet = HG.keySet();
        if (keySet.size() != 1) {
            fi(null);
        } else {
            fi(HG.get(keySet.iterator().next()));
        }
    }

    public void Hr() {
        HashMap<String, String> HM = HM();
        Set<String> keySet = HM.keySet();
        if (keySet.size() != 1) {
            fo(null);
        } else {
            fo(HM.get(keySet.iterator().next()));
        }
    }

    public int Hs() {
        return this.bhQ;
    }

    public void gV(int i) {
        this.bhQ = i;
    }

    public int Ht() {
        return this.bhT;
    }

    public void gW(int i) {
        this.bhT = i;
    }

    public int Hu() {
        return this.bhU;
    }

    public int Hv() {
        return this.bhY;
    }

    public void gX(int i) {
        this.bhY = i;
    }

    public int Hw() {
        return this.bic;
    }

    public void gY(int i) {
        this.bic = i;
    }

    public int Hx() {
        return this.bib;
    }

    public void gZ(int i) {
        this.bib = i;
    }

    public int Hy() {
        return this.bhQ;
    }

    public int Hz() {
        return this.bhS;
    }

    public void ha(int i) {
        this.bhS = i;
    }

    public boolean HA() {
        return this.bim;
    }

    public void bP(boolean z) {
        this.bim = z;
    }

    public String HB() {
        return this.bio;
    }

    public void fh(String str) {
        this.bio = str;
    }

    public String HC() {
        return this.biu;
    }

    public void fi(String str) {
        this.biu = str;
    }

    public void fj(String str) {
        this.biv = str;
    }

    public int HD() {
        return this.bhR;
    }

    public void hb(int i) {
        this.bhR = i;
    }

    public void fk(String str) {
        this.biw = str;
    }

    public String HE() {
        return this.biy;
    }

    public String HF() {
        return this.biz;
    }

    public HashMap<String, String> HG() {
        return this.bis;
    }

    public int HH() {
        return this.bhV;
    }

    public void hc(int i) {
        this.bhV = i;
    }

    public int HI() {
        return this.bhZ;
    }

    public void hd(int i) {
        this.bhZ = i;
    }

    public int HJ() {
        return this.bie;
    }

    public void he(int i) {
        this.bie = i;
    }

    public void fl(String str) {
        this.bip = str;
    }

    public void fm(String str) {
        this.biq = str;
    }

    public int HK() {
        return this.bia;
    }

    public void hf(int i) {
        this.bia = i;
    }

    public String HL() {
        return this.bir;
    }

    public void fn(String str) {
        this.bir = str;
    }

    public HashMap<String, String> HM() {
        return this.bit;
    }

    public String HN() {
        return this.bix;
    }

    public void fo(String str) {
        this.bix = str;
    }

    public int HO() {
        return this.bhW;
    }

    public int HP() {
        return this.bhX;
    }

    public void hg(int i) {
        this.bhW = i;
    }

    public void hh(int i) {
        this.bhX = i;
    }

    public void fp(String str) {
        this.biA = str;
    }

    public void fq(String str) {
        this.biB = str;
    }

    public int HQ() {
        return this.bih;
    }

    public void hi(int i) {
        this.bih = i;
    }

    public int HR() {
        return this.bii;
    }

    public void hj(int i) {
        this.bii = i;
    }

    public int HS() {
        return this.bij;
    }

    public void hk(int i) {
        this.bij = i;
    }

    public int HT() {
        return this.bik;
    }

    public void hl(int i) {
        this.bik = i;
    }

    public List<b> HU() {
        return this.biC;
    }

    public List<a> HV() {
        return this.biD;
    }

    public int HW() {
        return this.bil;
    }

    public void hm(int i) {
        this.bil = i;
    }
}
