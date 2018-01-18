package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String bif;
    private String bih;
    private String bii;
    private String bij;
    private String bim;
    private String bin;
    private String bio;
    private String bip;
    private String biq;
    private String bir;
    private int bhI = 0;
    private int bhJ = 0;
    private int bhK = 0;
    private int bhL = 0;
    private int bhM = 0;
    private int bhN = 0;
    private int bhO = 0;
    private int bhP = 0;
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
    private boolean bic = true;
    private boolean bie = true;
    private HashMap<String, String> bik = new HashMap<>();
    private HashMap<String, String> bil = new HashMap<>();
    private String bis = null;
    private String bit = null;
    private List<b> biu = new ArrayList();
    private List<a> biv = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int biw;
        public int bix;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int biw;
        public int bix;
        public String biy;
        public String biz;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Ho() {
        HashMap<String, String> HE = HE();
        Set<String> keySet = HE.keySet();
        if (keySet.size() != 1) {
            fb(null);
        } else {
            fb(HE.get(keySet.iterator().next()));
        }
    }

    public void Hp() {
        HashMap<String, String> HK = HK();
        Set<String> keySet = HK.keySet();
        if (keySet.size() != 1) {
            fh(null);
        } else {
            fh(HK.get(keySet.iterator().next()));
        }
    }

    public int Hq() {
        return this.bhI;
    }

    public void gV(int i) {
        this.bhI = i;
    }

    public int Hr() {
        return this.bhL;
    }

    public void gW(int i) {
        this.bhL = i;
    }

    public int Hs() {
        return this.bhM;
    }

    public int Ht() {
        return this.bhQ;
    }

    public void gX(int i) {
        this.bhQ = i;
    }

    public int Hu() {
        return this.bhU;
    }

    public void gY(int i) {
        this.bhU = i;
    }

    public int Hv() {
        return this.bhT;
    }

    public void gZ(int i) {
        this.bhT = i;
    }

    public int Hw() {
        return this.bhI;
    }

    public int Hx() {
        return this.bhK;
    }

    public void ha(int i) {
        this.bhK = i;
    }

    public boolean Hy() {
        return this.bic;
    }

    public void bO(boolean z) {
        this.bic = z;
    }

    public String Hz() {
        return this.bif;
    }

    public void fa(String str) {
        this.bif = str;
    }

    public String HA() {
        return this.bim;
    }

    public void fb(String str) {
        this.bim = str;
    }

    public void fc(String str) {
        this.bin = str;
    }

    public int HB() {
        return this.bhJ;
    }

    public void hb(int i) {
        this.bhJ = i;
    }

    public void fd(String str) {
        this.bio = str;
    }

    public String HC() {
        return this.biq;
    }

    public String HD() {
        return this.bir;
    }

    public HashMap<String, String> HE() {
        return this.bik;
    }

    public int HF() {
        return this.bhN;
    }

    public void hc(int i) {
        this.bhN = i;
    }

    public int HG() {
        return this.bhR;
    }

    public void hd(int i) {
        this.bhR = i;
    }

    public int HH() {
        return this.bhV;
    }

    public void he(int i) {
        this.bhV = i;
    }

    public void fe(String str) {
        this.bih = str;
    }

    public void ff(String str) {
        this.bii = str;
    }

    public int HI() {
        return this.bhS;
    }

    public void hf(int i) {
        this.bhS = i;
    }

    public String HJ() {
        return this.bij;
    }

    public void fg(String str) {
        this.bij = str;
    }

    public HashMap<String, String> HK() {
        return this.bil;
    }

    public String HL() {
        return this.bip;
    }

    public void fh(String str) {
        this.bip = str;
    }

    public int HM() {
        return this.bhO;
    }

    public int HN() {
        return this.bhP;
    }

    public void hg(int i) {
        this.bhO = i;
    }

    public void hh(int i) {
        this.bhP = i;
    }

    public void fi(String str) {
        this.bis = str;
    }

    public void fj(String str) {
        this.bit = str;
    }

    public int HO() {
        return this.bhX;
    }

    public void hi(int i) {
        this.bhX = i;
    }

    public int HP() {
        return this.bhY;
    }

    public void hj(int i) {
        this.bhY = i;
    }

    public int HQ() {
        return this.bhZ;
    }

    public void hk(int i) {
        this.bhZ = i;
    }

    public int HR() {
        return this.bia;
    }

    public void hl(int i) {
        this.bia = i;
    }

    public List<b> HS() {
        return this.biu;
    }

    public List<a> HT() {
        return this.biv;
    }

    public int HU() {
        return this.bib;
    }

    public void hm(int i) {
        this.bib = i;
    }
}
