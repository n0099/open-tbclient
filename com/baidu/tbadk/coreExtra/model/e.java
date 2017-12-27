package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String bhN;
    private String bhO;
    private String bhP;
    private String bhQ;
    private String bhT;
    private String bhU;
    private String bhV;
    private String bhW;
    private String bhX;
    private String bhY;
    private int bhr = 0;
    private int bhs = 0;
    private int bht = 0;
    private int bhu = 0;
    private int bhv = 0;
    private int bhw = 0;
    private int bhx = 0;
    private int bhy = 0;
    private int bhz = 0;
    private int bhA = 0;
    private int bhB = 0;
    private int bhC = 0;
    private int bhD = 0;
    private int bhE = 0;
    private int bhF = 0;
    private int bhG = 0;
    private int bhH = 0;
    private int bhI = 0;
    private int bhJ = 0;
    private int bhK = 0;
    private boolean bhL = true;
    private boolean bhM = true;
    private HashMap<String, String> bhR = new HashMap<>();
    private HashMap<String, String> bhS = new HashMap<>();
    private String bhZ = null;
    private String bia = null;
    private List<b> bib = new ArrayList();
    private List<a> bic = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int bie;
        public int bif;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bie;
        public int bif;
        public String bih;
        public String bii;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Hv() {
        HashMap<String, String> HL = HL();
        Set<String> keySet = HL.keySet();
        if (keySet.size() != 1) {
            fb(null);
        } else {
            fb(HL.get(keySet.iterator().next()));
        }
    }

    public void Hw() {
        HashMap<String, String> HR = HR();
        Set<String> keySet = HR.keySet();
        if (keySet.size() != 1) {
            fh(null);
        } else {
            fh(HR.get(keySet.iterator().next()));
        }
    }

    public int Hx() {
        return this.bhr;
    }

    public void gY(int i) {
        this.bhr = i;
    }

    public int Hy() {
        return this.bhu;
    }

    public void gZ(int i) {
        this.bhu = i;
    }

    public int Hz() {
        return this.bhv;
    }

    public int HA() {
        return this.bhz;
    }

    public void ha(int i) {
        this.bhz = i;
    }

    public int HB() {
        return this.bhD;
    }

    public void hb(int i) {
        this.bhD = i;
    }

    public int HC() {
        return this.bhC;
    }

    public void hc(int i) {
        this.bhC = i;
    }

    public int HD() {
        return this.bhr;
    }

    public int HE() {
        return this.bht;
    }

    public void hd(int i) {
        this.bht = i;
    }

    public boolean HF() {
        return this.bhL;
    }

    public void bO(boolean z) {
        this.bhL = z;
    }

    public String HG() {
        return this.bhN;
    }

    public void fa(String str) {
        this.bhN = str;
    }

    public String HH() {
        return this.bhT;
    }

    public void fb(String str) {
        this.bhT = str;
    }

    public void fc(String str) {
        this.bhU = str;
    }

    public int HI() {
        return this.bhs;
    }

    public void he(int i) {
        this.bhs = i;
    }

    public void fd(String str) {
        this.bhV = str;
    }

    public String HJ() {
        return this.bhX;
    }

    public String HK() {
        return this.bhY;
    }

    public HashMap<String, String> HL() {
        return this.bhR;
    }

    public int HM() {
        return this.bhw;
    }

    public void hf(int i) {
        this.bhw = i;
    }

    public int HN() {
        return this.bhA;
    }

    public void hg(int i) {
        this.bhA = i;
    }

    public int HO() {
        return this.bhE;
    }

    public void hh(int i) {
        this.bhE = i;
    }

    public void fe(String str) {
        this.bhO = str;
    }

    public void ff(String str) {
        this.bhP = str;
    }

    public int HP() {
        return this.bhB;
    }

    public void hi(int i) {
        this.bhB = i;
    }

    public String HQ() {
        return this.bhQ;
    }

    public void fg(String str) {
        this.bhQ = str;
    }

    public HashMap<String, String> HR() {
        return this.bhS;
    }

    public String HS() {
        return this.bhW;
    }

    public void fh(String str) {
        this.bhW = str;
    }

    public int HT() {
        return this.bhx;
    }

    public int HU() {
        return this.bhy;
    }

    public void hj(int i) {
        this.bhx = i;
    }

    public void hk(int i) {
        this.bhy = i;
    }

    public void fi(String str) {
        this.bhZ = str;
    }

    public void fj(String str) {
        this.bia = str;
    }

    public int HV() {
        return this.bhG;
    }

    public void hl(int i) {
        this.bhG = i;
    }

    public int HW() {
        return this.bhH;
    }

    public void hm(int i) {
        this.bhH = i;
    }

    public int HX() {
        return this.bhI;
    }

    public void hn(int i) {
        this.bhI = i;
    }

    public int HY() {
        return this.bhJ;
    }

    public void ho(int i) {
        this.bhJ = i;
    }

    public List<b> HZ() {
        return this.bib;
    }

    public List<a> Ia() {
        return this.bic;
    }

    public int Ib() {
        return this.bhK;
    }

    public void hp(int i) {
        this.bhK = i;
    }
}
