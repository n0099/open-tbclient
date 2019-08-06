package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String cjJ;
    private String cjK;
    private String cjL;
    private String cjM;
    private String cjP;
    private String cjQ;
    private String cjR;
    private String cjS;
    private String cjT;
    private String cjU;
    private int cjr = 0;
    private int cjs = 0;
    private int cjt = 0;
    private int cju = 0;
    private int cjv = 0;
    private int cjw = 0;
    private int cjx = 0;
    private int cjy = 0;
    private int cjz = 0;
    private int cjA = 0;
    private int cjB = 0;
    private int cjC = 0;
    private int cjD = 0;
    private int cjE = 0;
    private int cjF = 0;
    private int cjG = 0;
    private boolean cjH = true;
    private boolean cjI = true;
    private HashMap<String, String> cjN = new HashMap<>();
    private HashMap<String, String> cjO = new HashMap<>();
    private List<a> cjV = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String cjW;
        public String cjX;
        public int cjY;
        public String cjZ;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void apb() {
        HashMap<String, String> aps = aps();
        Set<String> keySet = aps.keySet();
        if (keySet.size() != 1) {
            pq(null);
        } else {
            pq(aps.get(keySet.iterator().next()));
        }
    }

    public void apc() {
        HashMap<String, String> apy = apy();
        Set<String> keySet = apy.keySet();
        if (keySet.size() != 1) {
            pw(null);
        } else {
            pw(apy.get(keySet.iterator().next()));
        }
    }

    public int apd() {
        return this.cjr;
    }

    public void jA(int i) {
        this.cjr = i;
    }

    public int ape() {
        return this.cju;
    }

    public void jB(int i) {
        this.cju = i;
    }

    public int apf() {
        return this.cjv;
    }

    public int apg() {
        return this.cjx;
    }

    public void jC(int i) {
        this.cjx = i;
    }

    public int aph() {
        return this.cjB;
    }

    public void jD(int i) {
        this.cjB = i;
    }

    public int apj() {
        return this.cjA;
    }

    public void jE(int i) {
        this.cjA = i;
    }

    public int apk() {
        return this.cjr;
    }

    public int apl() {
        return this.cjt;
    }

    public void jF(int i) {
        this.cjt = i;
    }

    public boolean apm() {
        return this.cjH;
    }

    public void eP(boolean z) {
        this.cjH = z;
    }

    public String apn() {
        return this.cjJ;
    }

    public void pp(String str) {
        this.cjJ = str;
    }

    public String apo() {
        return this.cjP;
    }

    public void pq(String str) {
        this.cjP = str;
    }

    public void pr(String str) {
        this.cjQ = str;
    }

    public int app() {
        return this.cjs;
    }

    public void jG(int i) {
        this.cjs = i;
    }

    public void ps(String str) {
        this.cjR = str;
    }

    public String apq() {
        return this.cjT;
    }

    public String apr() {
        return this.cjU;
    }

    public HashMap<String, String> aps() {
        return this.cjN;
    }

    public int apt() {
        return this.cjw;
    }

    public void jH(int i) {
        this.cjw = i;
    }

    public int apu() {
        return this.cjy;
    }

    public void jI(int i) {
        this.cjy = i;
    }

    public int apv() {
        return this.cjC;
    }

    public void jJ(int i) {
        this.cjC = i;
    }

    public void pt(String str) {
        this.cjK = str;
    }

    public void pu(String str) {
        this.cjL = str;
    }

    public int apw() {
        return this.cjz;
    }

    public void jK(int i) {
        this.cjz = i;
    }

    public String apx() {
        return this.cjM;
    }

    public void pv(String str) {
        this.cjM = str;
    }

    public HashMap<String, String> apy() {
        return this.cjO;
    }

    public String apz() {
        return this.cjS;
    }

    public void pw(String str) {
        this.cjS = str;
    }

    public int apA() {
        return this.cjE;
    }

    public void jL(int i) {
        this.cjE = i;
    }

    public int apB() {
        return this.cjF;
    }

    public void jM(int i) {
        this.cjF = i;
    }

    public List<a> apC() {
        return this.cjV;
    }

    public int apD() {
        return this.cjG;
    }

    public void jN(int i) {
        this.cjG = i;
    }
}
