package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String bkC;
    private String bkD;
    private String bkE;
    private String bkF;
    private String bkG;
    private String bkH;
    private String bkw;
    private String bkx;
    private String bky;
    private String bkz;
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
    private int bkr = 0;
    private int bks = 0;
    private int bkt = 0;
    private boolean bku = true;
    private boolean bkv = true;
    private HashMap<String, String> bkA = new HashMap<>();
    private HashMap<String, String> bkB = new HashMap<>();
    private List<a> bkI = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String bkJ;
        public String bkK;
        public int bkL;
        public String bkM;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Ib() {
        HashMap<String, String> Ir = Ir();
        Set<String> keySet = Ir.keySet();
        if (keySet.size() != 1) {
            fu(null);
        } else {
            fu(Ir.get(keySet.iterator().next()));
        }
    }

    public void Ic() {
        HashMap<String, String> Ix = Ix();
        Set<String> keySet = Ix.keySet();
        if (keySet.size() != 1) {
            fA(null);
        } else {
            fA(Ix.get(keySet.iterator().next()));
        }
    }

    public int Id() {
        return this.bke;
    }

    public void gY(int i) {
        this.bke = i;
    }

    public int Ie() {
        return this.bkh;
    }

    public void gZ(int i) {
        this.bkh = i;
    }

    public int If() {
        return this.bki;
    }

    public int Ig() {
        return this.bkk;
    }

    public void ha(int i) {
        this.bkk = i;
    }

    public int Ih() {
        return this.bko;
    }

    public void hb(int i) {
        this.bko = i;
    }

    public int Ii() {
        return this.bkn;
    }

    public void hc(int i) {
        this.bkn = i;
    }

    public int Ij() {
        return this.bke;
    }

    public int Ik() {
        return this.bkg;
    }

    public void hd(int i) {
        this.bkg = i;
    }

    public boolean Il() {
        return this.bku;
    }

    public void bT(boolean z) {
        this.bku = z;
    }

    public String Im() {
        return this.bkw;
    }

    public void ft(String str) {
        this.bkw = str;
    }

    public String In() {
        return this.bkC;
    }

    public void fu(String str) {
        this.bkC = str;
    }

    public void fv(String str) {
        this.bkD = str;
    }

    public int Io() {
        return this.bkf;
    }

    public void he(int i) {
        this.bkf = i;
    }

    public void fw(String str) {
        this.bkE = str;
    }

    public String Ip() {
        return this.bkG;
    }

    public String Iq() {
        return this.bkH;
    }

    public HashMap<String, String> Ir() {
        return this.bkA;
    }

    public int Is() {
        return this.bkj;
    }

    public void hf(int i) {
        this.bkj = i;
    }

    public int It() {
        return this.bkl;
    }

    public void hg(int i) {
        this.bkl = i;
    }

    public int Iu() {
        return this.bkp;
    }

    public void hh(int i) {
        this.bkp = i;
    }

    public void fx(String str) {
        this.bkx = str;
    }

    public void fy(String str) {
        this.bky = str;
    }

    public int Iv() {
        return this.bkm;
    }

    public void hi(int i) {
        this.bkm = i;
    }

    public String Iw() {
        return this.bkz;
    }

    public void fz(String str) {
        this.bkz = str;
    }

    public HashMap<String, String> Ix() {
        return this.bkB;
    }

    public String Iy() {
        return this.bkF;
    }

    public void fA(String str) {
        this.bkF = str;
    }

    public int Iz() {
        return this.bkr;
    }

    public void hj(int i) {
        this.bkr = i;
    }

    public int IA() {
        return this.bks;
    }

    public void hk(int i) {
        this.bks = i;
    }

    public List<a> IB() {
        return this.bkI;
    }

    public int IC() {
        return this.bkt;
    }

    public void hl(int i) {
        this.bkt = i;
    }
}
