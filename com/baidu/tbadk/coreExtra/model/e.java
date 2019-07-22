package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String cjC;
    private String cjD;
    private String cjE;
    private String cjF;
    private String cjI;
    private String cjJ;
    private String cjK;
    private String cjL;
    private String cjM;
    private String cjN;
    private int cjk = 0;
    private int cjl = 0;
    private int cjm = 0;
    private int cjn = 0;
    private int cjo = 0;
    private int cjp = 0;
    private int cjq = 0;
    private int cjr = 0;
    private int cjs = 0;
    private int cjt = 0;
    private int cju = 0;
    private int cjv = 0;
    private int cjw = 0;
    private int cjx = 0;
    private int cjy = 0;
    private int cjz = 0;
    private boolean cjA = true;
    private boolean cjB = true;
    private HashMap<String, String> cjG = new HashMap<>();
    private HashMap<String, String> cjH = new HashMap<>();
    private List<a> cjO = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String cjP;
        public String cjQ;
        public int cjR;
        public String cjS;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void aoZ() {
        HashMap<String, String> apq = apq();
        Set<String> keySet = apq.keySet();
        if (keySet.size() != 1) {
            pq(null);
        } else {
            pq(apq.get(keySet.iterator().next()));
        }
    }

    public void apa() {
        HashMap<String, String> apw = apw();
        Set<String> keySet = apw.keySet();
        if (keySet.size() != 1) {
            pw(null);
        } else {
            pw(apw.get(keySet.iterator().next()));
        }
    }

    public int apb() {
        return this.cjk;
    }

    public void jz(int i) {
        this.cjk = i;
    }

    public int apc() {
        return this.cjn;
    }

    public void jA(int i) {
        this.cjn = i;
    }

    public int apd() {
        return this.cjo;
    }

    public int ape() {
        return this.cjq;
    }

    public void jB(int i) {
        this.cjq = i;
    }

    public int apf() {
        return this.cju;
    }

    public void jC(int i) {
        this.cju = i;
    }

    public int apg() {
        return this.cjt;
    }

    public void jD(int i) {
        this.cjt = i;
    }

    public int aph() {
        return this.cjk;
    }

    public int apj() {
        return this.cjm;
    }

    public void jE(int i) {
        this.cjm = i;
    }

    public boolean apk() {
        return this.cjA;
    }

    public void eP(boolean z) {
        this.cjA = z;
    }

    public String apl() {
        return this.cjC;
    }

    public void pp(String str) {
        this.cjC = str;
    }

    public String apm() {
        return this.cjI;
    }

    public void pq(String str) {
        this.cjI = str;
    }

    public void pr(String str) {
        this.cjJ = str;
    }

    public int apn() {
        return this.cjl;
    }

    public void jF(int i) {
        this.cjl = i;
    }

    public void ps(String str) {
        this.cjK = str;
    }

    public String apo() {
        return this.cjM;
    }

    public String app() {
        return this.cjN;
    }

    public HashMap<String, String> apq() {
        return this.cjG;
    }

    public int apr() {
        return this.cjp;
    }

    public void jG(int i) {
        this.cjp = i;
    }

    public int aps() {
        return this.cjr;
    }

    public void jH(int i) {
        this.cjr = i;
    }

    public int apt() {
        return this.cjv;
    }

    public void jI(int i) {
        this.cjv = i;
    }

    public void pt(String str) {
        this.cjD = str;
    }

    public void pu(String str) {
        this.cjE = str;
    }

    public int apu() {
        return this.cjs;
    }

    public void jJ(int i) {
        this.cjs = i;
    }

    public String apv() {
        return this.cjF;
    }

    public void pv(String str) {
        this.cjF = str;
    }

    public HashMap<String, String> apw() {
        return this.cjH;
    }

    public String apx() {
        return this.cjL;
    }

    public void pw(String str) {
        this.cjL = str;
    }

    public int apy() {
        return this.cjx;
    }

    public void jK(int i) {
        this.cjx = i;
    }

    public int apz() {
        return this.cjy;
    }

    public void jL(int i) {
        this.cjy = i;
    }

    public List<a> apA() {
        return this.cjO;
    }

    public int apB() {
        return this.cjz;
    }

    public void jM(int i) {
        this.cjz = i;
    }
}
