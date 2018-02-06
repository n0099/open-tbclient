package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String bkG;
    private String bkH;
    private String bkI;
    private String bkJ;
    private String bkM;
    private String bkN;
    private String bkO;
    private String bkP;
    private String bkQ;
    private String bkR;
    private int bko = 0;
    private int bkp = 0;
    private int bkq = 0;
    private int bkr = 0;
    private int bks = 0;
    private int bkt = 0;
    private int bku = 0;
    private int bkv = 0;
    private int bkw = 0;
    private int bkx = 0;
    private int bky = 0;
    private int bkz = 0;
    private int bkA = 0;
    private int bkB = 0;
    private int bkC = 0;
    private int bkD = 0;
    private boolean bkE = true;
    private boolean bkF = true;
    private HashMap<String, String> bkK = new HashMap<>();
    private HashMap<String, String> bkL = new HashMap<>();
    private List<a> bkS = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String bkT;
        public String bkU;
        public int bkV;
        public String bkW;
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
        return this.bko;
    }

    public void gY(int i) {
        this.bko = i;
    }

    public int Ie() {
        return this.bkr;
    }

    public void gZ(int i) {
        this.bkr = i;
    }

    public int If() {
        return this.bks;
    }

    public int Ig() {
        return this.bku;
    }

    public void ha(int i) {
        this.bku = i;
    }

    public int Ih() {
        return this.bky;
    }

    public void hb(int i) {
        this.bky = i;
    }

    public int Ii() {
        return this.bkx;
    }

    public void hc(int i) {
        this.bkx = i;
    }

    public int Ij() {
        return this.bko;
    }

    public int Ik() {
        return this.bkq;
    }

    public void hd(int i) {
        this.bkq = i;
    }

    public boolean Il() {
        return this.bkE;
    }

    public void bT(boolean z) {
        this.bkE = z;
    }

    public String Im() {
        return this.bkG;
    }

    public void ft(String str) {
        this.bkG = str;
    }

    public String In() {
        return this.bkM;
    }

    public void fu(String str) {
        this.bkM = str;
    }

    public void fv(String str) {
        this.bkN = str;
    }

    public int Io() {
        return this.bkp;
    }

    public void he(int i) {
        this.bkp = i;
    }

    public void fw(String str) {
        this.bkO = str;
    }

    public String Ip() {
        return this.bkQ;
    }

    public String Iq() {
        return this.bkR;
    }

    public HashMap<String, String> Ir() {
        return this.bkK;
    }

    public int Is() {
        return this.bkt;
    }

    public void hf(int i) {
        this.bkt = i;
    }

    public int It() {
        return this.bkv;
    }

    public void hg(int i) {
        this.bkv = i;
    }

    public int Iu() {
        return this.bkz;
    }

    public void hh(int i) {
        this.bkz = i;
    }

    public void fx(String str) {
        this.bkH = str;
    }

    public void fy(String str) {
        this.bkI = str;
    }

    public int Iv() {
        return this.bkw;
    }

    public void hi(int i) {
        this.bkw = i;
    }

    public String Iw() {
        return this.bkJ;
    }

    public void fz(String str) {
        this.bkJ = str;
    }

    public HashMap<String, String> Ix() {
        return this.bkL;
    }

    public String Iy() {
        return this.bkP;
    }

    public void fA(String str) {
        this.bkP = str;
    }

    public int Iz() {
        return this.bkB;
    }

    public void hj(int i) {
        this.bkB = i;
    }

    public int IA() {
        return this.bkC;
    }

    public void hk(int i) {
        this.bkC = i;
    }

    public List<a> IB() {
        return this.bkS;
    }

    public int IC() {
        return this.bkD;
    }

    public void hl(int i) {
        this.bkD = i;
    }
}
