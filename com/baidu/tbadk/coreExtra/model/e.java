package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String bkA;
    private String bkB;
    private String bkC;
    private String bkD;
    private String bkE;
    private String bkt;
    private String bku;
    private String bkv;
    private String bkw;
    private String bkz;
    private int bkb = 0;
    private int bkc = 0;
    private int bkd = 0;
    private int bke = 0;
    private int bkf = 0;
    private int bkg = 0;
    private int bkh = 0;
    private int bki = 0;
    private int bkj = 0;
    private int bkk = 0;
    private int bkl = 0;
    private int bkm = 0;
    private int bkn = 0;
    private int bko = 0;
    private int bkp = 0;
    private int bkq = 0;
    private boolean bkr = true;
    private boolean bks = true;
    private HashMap<String, String> bkx = new HashMap<>();
    private HashMap<String, String> bky = new HashMap<>();
    private List<a> bkF = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String bkG;
        public String bkH;
        public int bkI;
        public String bkJ;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Ia() {
        HashMap<String, String> Iq = Iq();
        Set<String> keySet = Iq.keySet();
        if (keySet.size() != 1) {
            fu(null);
        } else {
            fu(Iq.get(keySet.iterator().next()));
        }
    }

    public void Ib() {
        HashMap<String, String> Iw = Iw();
        Set<String> keySet = Iw.keySet();
        if (keySet.size() != 1) {
            fA(null);
        } else {
            fA(Iw.get(keySet.iterator().next()));
        }
    }

    public int Ic() {
        return this.bkb;
    }

    public void gY(int i) {
        this.bkb = i;
    }

    public int Id() {
        return this.bke;
    }

    public void gZ(int i) {
        this.bke = i;
    }

    public int Ie() {
        return this.bkf;
    }

    public int If() {
        return this.bkh;
    }

    public void ha(int i) {
        this.bkh = i;
    }

    public int Ig() {
        return this.bkl;
    }

    public void hb(int i) {
        this.bkl = i;
    }

    public int Ih() {
        return this.bkk;
    }

    public void hc(int i) {
        this.bkk = i;
    }

    public int Ii() {
        return this.bkb;
    }

    public int Ij() {
        return this.bkd;
    }

    public void hd(int i) {
        this.bkd = i;
    }

    public boolean Ik() {
        return this.bkr;
    }

    public void bT(boolean z) {
        this.bkr = z;
    }

    public String Il() {
        return this.bkt;
    }

    public void ft(String str) {
        this.bkt = str;
    }

    public String Im() {
        return this.bkz;
    }

    public void fu(String str) {
        this.bkz = str;
    }

    public void fv(String str) {
        this.bkA = str;
    }

    public int In() {
        return this.bkc;
    }

    public void he(int i) {
        this.bkc = i;
    }

    public void fw(String str) {
        this.bkB = str;
    }

    public String Io() {
        return this.bkD;
    }

    public String Ip() {
        return this.bkE;
    }

    public HashMap<String, String> Iq() {
        return this.bkx;
    }

    public int Ir() {
        return this.bkg;
    }

    public void hf(int i) {
        this.bkg = i;
    }

    public int Is() {
        return this.bki;
    }

    public void hg(int i) {
        this.bki = i;
    }

    public int It() {
        return this.bkm;
    }

    public void hh(int i) {
        this.bkm = i;
    }

    public void fx(String str) {
        this.bku = str;
    }

    public void fy(String str) {
        this.bkv = str;
    }

    public int Iu() {
        return this.bkj;
    }

    public void hi(int i) {
        this.bkj = i;
    }

    public String Iv() {
        return this.bkw;
    }

    public void fz(String str) {
        this.bkw = str;
    }

    public HashMap<String, String> Iw() {
        return this.bky;
    }

    public String Ix() {
        return this.bkC;
    }

    public void fA(String str) {
        this.bkC = str;
    }

    public int Iy() {
        return this.bko;
    }

    public void hj(int i) {
        this.bko = i;
    }

    public int Iz() {
        return this.bkp;
    }

    public void hk(int i) {
        this.bkp = i;
    }

    public List<a> IA() {
        return this.bkF;
    }

    public int IB() {
        return this.bkq;
    }

    public void hl(int i) {
        this.bkq = i;
    }
}
