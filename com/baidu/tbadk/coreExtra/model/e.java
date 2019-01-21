package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aRR;
    private String aRS;
    private String aRT;
    private String aRU;
    private String aRX;
    private String aRY;
    private String aRZ;
    private String aSa;
    private String aSb;
    private String aSc;
    private int aRz = 0;
    private int aRA = 0;
    private int aRB = 0;
    private int aRC = 0;
    private int aRD = 0;
    private int aRE = 0;
    private int aRF = 0;
    private int aRG = 0;
    private int aRH = 0;
    private int aRI = 0;
    private int aRJ = 0;
    private int aRK = 0;
    private int aRL = 0;
    private int aRM = 0;
    private int aRN = 0;
    private int aRO = 0;
    private boolean aRP = true;
    private boolean aRQ = true;
    private HashMap<String, String> aRV = new HashMap<>();
    private HashMap<String, String> aRW = new HashMap<>();
    private List<a> aSd = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aSe;
        public String aSf;
        public int aSg;
        public String aSh;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Jz() {
        HashMap<String, String> JP = JP();
        Set<String> keySet = JP.keySet();
        if (keySet.size() != 1) {
            hd(null);
        } else {
            hd(JP.get(keySet.iterator().next()));
        }
    }

    public void JA() {
        HashMap<String, String> JV = JV();
        Set<String> keySet = JV.keySet();
        if (keySet.size() != 1) {
            hj(null);
        } else {
            hj(JV.get(keySet.iterator().next()));
        }
    }

    public int JB() {
        return this.aRz;
    }

    public void fa(int i) {
        this.aRz = i;
    }

    public int JC() {
        return this.aRC;
    }

    public void fb(int i) {
        this.aRC = i;
    }

    public int JD() {
        return this.aRD;
    }

    public int JE() {
        return this.aRF;
    }

    public void fc(int i) {
        this.aRF = i;
    }

    public int JF() {
        return this.aRJ;
    }

    public void fd(int i) {
        this.aRJ = i;
    }

    public int JG() {
        return this.aRI;
    }

    public void fe(int i) {
        this.aRI = i;
    }

    public int JH() {
        return this.aRz;
    }

    public int JI() {
        return this.aRB;
    }

    public void ff(int i) {
        this.aRB = i;
    }

    public boolean JJ() {
        return this.aRP;
    }

    public void cf(boolean z) {
        this.aRP = z;
    }

    public String JK() {
        return this.aRR;
    }

    public void hc(String str) {
        this.aRR = str;
    }

    public String JL() {
        return this.aRX;
    }

    public void hd(String str) {
        this.aRX = str;
    }

    public void he(String str) {
        this.aRY = str;
    }

    public int JM() {
        return this.aRA;
    }

    public void fg(int i) {
        this.aRA = i;
    }

    public void hf(String str) {
        this.aRZ = str;
    }

    public String JN() {
        return this.aSb;
    }

    public String JO() {
        return this.aSc;
    }

    public HashMap<String, String> JP() {
        return this.aRV;
    }

    public int JQ() {
        return this.aRE;
    }

    public void fh(int i) {
        this.aRE = i;
    }

    public int JR() {
        return this.aRG;
    }

    public void fi(int i) {
        this.aRG = i;
    }

    public int JS() {
        return this.aRK;
    }

    public void fj(int i) {
        this.aRK = i;
    }

    public void hg(String str) {
        this.aRS = str;
    }

    public void hh(String str) {
        this.aRT = str;
    }

    public int JT() {
        return this.aRH;
    }

    public void fk(int i) {
        this.aRH = i;
    }

    public String JU() {
        return this.aRU;
    }

    public void hi(String str) {
        this.aRU = str;
    }

    public HashMap<String, String> JV() {
        return this.aRW;
    }

    public String JW() {
        return this.aSa;
    }

    public void hj(String str) {
        this.aSa = str;
    }

    public int JX() {
        return this.aRM;
    }

    public void fl(int i) {
        this.aRM = i;
    }

    public int JY() {
        return this.aRN;
    }

    public void fm(int i) {
        this.aRN = i;
    }

    public List<a> JZ() {
        return this.aSd;
    }

    public int Ka() {
        return this.aRO;
    }

    public void fn(int i) {
        this.aRO = i;
    }
}
