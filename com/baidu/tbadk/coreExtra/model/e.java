package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aRm;
    private String aRn;
    private String aRo;
    private String aRp;
    private String aRs;
    private String aRt;
    private String aRu;
    private String aRv;
    private String aRw;
    private String aRx;
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
    private int aRi = 0;
    private int aRj = 0;
    private boolean aRk = true;
    private boolean aRl = true;
    private HashMap<String, String> aRq = new HashMap<>();
    private HashMap<String, String> aRr = new HashMap<>();
    private List<a> aRy = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aRA;
        public int aRB;
        public String aRC;
        public String aRz;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Jk() {
        HashMap<String, String> JA = JA();
        Set<String> keySet = JA.keySet();
        if (keySet.size() != 1) {
            gQ(null);
        } else {
            gQ(JA.get(keySet.iterator().next()));
        }
    }

    public void Jl() {
        HashMap<String, String> JG = JG();
        Set<String> keySet = JG.keySet();
        if (keySet.size() != 1) {
            gW(null);
        } else {
            gW(JG.get(keySet.iterator().next()));
        }
    }

    public int Jm() {
        return this.aQU;
    }

    public void fa(int i) {
        this.aQU = i;
    }

    public int Jn() {
        return this.aQX;
    }

    public void fb(int i) {
        this.aQX = i;
    }

    public int Jo() {
        return this.aQY;
    }

    public int Jp() {
        return this.aRa;
    }

    public void fc(int i) {
        this.aRa = i;
    }

    public int Jq() {
        return this.aRe;
    }

    public void fd(int i) {
        this.aRe = i;
    }

    public int Jr() {
        return this.aRd;
    }

    public void fe(int i) {
        this.aRd = i;
    }

    public int Js() {
        return this.aQU;
    }

    public int Jt() {
        return this.aQW;
    }

    public void ff(int i) {
        this.aQW = i;
    }

    public boolean Ju() {
        return this.aRk;
    }

    public void ce(boolean z) {
        this.aRk = z;
    }

    public String Jv() {
        return this.aRm;
    }

    public void gP(String str) {
        this.aRm = str;
    }

    public String Jw() {
        return this.aRs;
    }

    public void gQ(String str) {
        this.aRs = str;
    }

    public void gR(String str) {
        this.aRt = str;
    }

    public int Jx() {
        return this.aQV;
    }

    public void fg(int i) {
        this.aQV = i;
    }

    public void gS(String str) {
        this.aRu = str;
    }

    public String Jy() {
        return this.aRw;
    }

    public String Jz() {
        return this.aRx;
    }

    public HashMap<String, String> JA() {
        return this.aRq;
    }

    public int JB() {
        return this.aQZ;
    }

    public void fh(int i) {
        this.aQZ = i;
    }

    public int JC() {
        return this.aRb;
    }

    public void fi(int i) {
        this.aRb = i;
    }

    public int JD() {
        return this.aRf;
    }

    public void fj(int i) {
        this.aRf = i;
    }

    public void gT(String str) {
        this.aRn = str;
    }

    public void gU(String str) {
        this.aRo = str;
    }

    public int JE() {
        return this.aRc;
    }

    public void fk(int i) {
        this.aRc = i;
    }

    public String JF() {
        return this.aRp;
    }

    public void gV(String str) {
        this.aRp = str;
    }

    public HashMap<String, String> JG() {
        return this.aRr;
    }

    public String JH() {
        return this.aRv;
    }

    public void gW(String str) {
        this.aRv = str;
    }

    public int JI() {
        return this.aRh;
    }

    public void fl(int i) {
        this.aRh = i;
    }

    public int JJ() {
        return this.aRi;
    }

    public void fm(int i) {
        this.aRi = i;
    }

    public List<a> JK() {
        return this.aRy;
    }

    public int JL() {
        return this.aRj;
    }

    public void fn(int i) {
        this.aRj = i;
    }
}
