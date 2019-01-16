package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aRQ;
    private String aRR;
    private String aRS;
    private String aRT;
    private String aRW;
    private String aRX;
    private String aRY;
    private String aRZ;
    private String aSa;
    private String aSb;
    private int aRy = 0;
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
    private boolean aRO = true;
    private boolean aRP = true;
    private HashMap<String, String> aRU = new HashMap<>();
    private HashMap<String, String> aRV = new HashMap<>();
    private List<a> aSc = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aSd;
        public String aSe;
        public int aSf;
        public String aSg;
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
        return this.aRy;
    }

    public void fa(int i) {
        this.aRy = i;
    }

    public int JC() {
        return this.aRB;
    }

    public void fb(int i) {
        this.aRB = i;
    }

    public int JD() {
        return this.aRC;
    }

    public int JE() {
        return this.aRE;
    }

    public void fc(int i) {
        this.aRE = i;
    }

    public int JF() {
        return this.aRI;
    }

    public void fd(int i) {
        this.aRI = i;
    }

    public int JG() {
        return this.aRH;
    }

    public void fe(int i) {
        this.aRH = i;
    }

    public int JH() {
        return this.aRy;
    }

    public int JI() {
        return this.aRA;
    }

    public void ff(int i) {
        this.aRA = i;
    }

    public boolean JJ() {
        return this.aRO;
    }

    public void cf(boolean z) {
        this.aRO = z;
    }

    public String JK() {
        return this.aRQ;
    }

    public void hc(String str) {
        this.aRQ = str;
    }

    public String JL() {
        return this.aRW;
    }

    public void hd(String str) {
        this.aRW = str;
    }

    public void he(String str) {
        this.aRX = str;
    }

    public int JM() {
        return this.aRz;
    }

    public void fg(int i) {
        this.aRz = i;
    }

    public void hf(String str) {
        this.aRY = str;
    }

    public String JN() {
        return this.aSa;
    }

    public String JO() {
        return this.aSb;
    }

    public HashMap<String, String> JP() {
        return this.aRU;
    }

    public int JQ() {
        return this.aRD;
    }

    public void fh(int i) {
        this.aRD = i;
    }

    public int JR() {
        return this.aRF;
    }

    public void fi(int i) {
        this.aRF = i;
    }

    public int JS() {
        return this.aRJ;
    }

    public void fj(int i) {
        this.aRJ = i;
    }

    public void hg(String str) {
        this.aRR = str;
    }

    public void hh(String str) {
        this.aRS = str;
    }

    public int JT() {
        return this.aRG;
    }

    public void fk(int i) {
        this.aRG = i;
    }

    public String JU() {
        return this.aRT;
    }

    public void hi(String str) {
        this.aRT = str;
    }

    public HashMap<String, String> JV() {
        return this.aRV;
    }

    public String JW() {
        return this.aRZ;
    }

    public void hj(String str) {
        this.aRZ = str;
    }

    public int JX() {
        return this.aRL;
    }

    public void fl(int i) {
        this.aRL = i;
    }

    public int JY() {
        return this.aRM;
    }

    public void fm(int i) {
        this.aRM = i;
    }

    public List<a> JZ() {
        return this.aSc;
    }

    public int Ka() {
        return this.aRN;
    }

    public void fn(int i) {
        this.aRN = i;
    }
}
