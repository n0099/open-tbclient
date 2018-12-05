package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aRk;
    private String aRl;
    private String aRm;
    private String aRn;
    private String aRq;
    private String aRr;
    private String aRs;
    private String aRt;
    private String aRu;
    private String aRv;
    private int aQS = 0;
    private int aQT = 0;
    private int aQU = 0;
    private int aQV = 0;
    private int aQW = 0;
    private int aQX = 0;
    private int aQY = 0;
    private int aQZ = 0;
    private int aRa = 0;
    private int aRb = 0;
    private int aRc = 0;
    private int aRd = 0;
    private int aRe = 0;
    private int aRf = 0;
    private int aRg = 0;
    private int aRh = 0;
    private boolean aRi = true;
    private boolean aRj = true;
    private HashMap<String, String> aRo = new HashMap<>();
    private HashMap<String, String> aRp = new HashMap<>();
    private List<a> aRw = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aRA;
        public String aRx;
        public String aRy;
        public int aRz;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Jj() {
        HashMap<String, String> Jz = Jz();
        Set<String> keySet = Jz.keySet();
        if (keySet.size() != 1) {
            gP(null);
        } else {
            gP(Jz.get(keySet.iterator().next()));
        }
    }

    public void Jk() {
        HashMap<String, String> JF = JF();
        Set<String> keySet = JF.keySet();
        if (keySet.size() != 1) {
            gV(null);
        } else {
            gV(JF.get(keySet.iterator().next()));
        }
    }

    public int Jl() {
        return this.aQS;
    }

    public void eZ(int i) {
        this.aQS = i;
    }

    public int Jm() {
        return this.aQV;
    }

    public void fa(int i) {
        this.aQV = i;
    }

    public int Jn() {
        return this.aQW;
    }

    public int Jo() {
        return this.aQY;
    }

    public void fb(int i) {
        this.aQY = i;
    }

    public int Jp() {
        return this.aRc;
    }

    public void fc(int i) {
        this.aRc = i;
    }

    public int Jq() {
        return this.aRb;
    }

    public void fd(int i) {
        this.aRb = i;
    }

    public int Jr() {
        return this.aQS;
    }

    public int Js() {
        return this.aQU;
    }

    public void fe(int i) {
        this.aQU = i;
    }

    public boolean Jt() {
        return this.aRi;
    }

    public void ce(boolean z) {
        this.aRi = z;
    }

    public String Ju() {
        return this.aRk;
    }

    public void gO(String str) {
        this.aRk = str;
    }

    public String Jv() {
        return this.aRq;
    }

    public void gP(String str) {
        this.aRq = str;
    }

    public void gQ(String str) {
        this.aRr = str;
    }

    public int Jw() {
        return this.aQT;
    }

    public void ff(int i) {
        this.aQT = i;
    }

    public void gR(String str) {
        this.aRs = str;
    }

    public String Jx() {
        return this.aRu;
    }

    public String Jy() {
        return this.aRv;
    }

    public HashMap<String, String> Jz() {
        return this.aRo;
    }

    public int JA() {
        return this.aQX;
    }

    public void fg(int i) {
        this.aQX = i;
    }

    public int JB() {
        return this.aQZ;
    }

    public void fh(int i) {
        this.aQZ = i;
    }

    public int JC() {
        return this.aRd;
    }

    public void fi(int i) {
        this.aRd = i;
    }

    public void gS(String str) {
        this.aRl = str;
    }

    public void gT(String str) {
        this.aRm = str;
    }

    public int JD() {
        return this.aRa;
    }

    public void fj(int i) {
        this.aRa = i;
    }

    public String JE() {
        return this.aRn;
    }

    public void gU(String str) {
        this.aRn = str;
    }

    public HashMap<String, String> JF() {
        return this.aRp;
    }

    public String JG() {
        return this.aRt;
    }

    public void gV(String str) {
        this.aRt = str;
    }

    public int JH() {
        return this.aRf;
    }

    public void fk(int i) {
        this.aRf = i;
    }

    public int JI() {
        return this.aRg;
    }

    public void fl(int i) {
        this.aRg = i;
    }

    public List<a> JJ() {
        return this.aRw;
    }

    public int JK() {
        return this.aRh;
    }

    public void fm(int i) {
        this.aRh = i;
    }
}
