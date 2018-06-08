package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aEm;
    private String aEn;
    private String aEo;
    private String aEp;
    private String aEs;
    private String aEt;
    private String aEu;
    private String aEv;
    private String aEw;
    private String aEx;
    private int aDU = 0;
    private int aDV = 0;
    private int aDW = 0;
    private int aDX = 0;
    private int aDY = 0;
    private int aDZ = 0;
    private int aEa = 0;
    private int aEb = 0;
    private int aEc = 0;
    private int aEd = 0;
    private int aEe = 0;
    private int aEf = 0;
    private int aEg = 0;
    private int aEh = 0;
    private int aEi = 0;
    private int aEj = 0;
    private boolean aEk = true;
    private boolean aEl = true;
    private HashMap<String, String> aEq = new HashMap<>();
    private HashMap<String, String> aEr = new HashMap<>();
    private List<a> aEy = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aEA;
        public int aEB;
        public String aEC;
        public String aEz;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Eo() {
        HashMap<String, String> EE = EE();
        Set<String> keySet = EE.keySet();
        if (keySet.size() != 1) {
            fJ(null);
        } else {
            fJ(EE.get(keySet.iterator().next()));
        }
    }

    public void Ep() {
        HashMap<String, String> EK = EK();
        Set<String> keySet = EK.keySet();
        if (keySet.size() != 1) {
            fP(null);
        } else {
            fP(EK.get(keySet.iterator().next()));
        }
    }

    public int Eq() {
        return this.aDU;
    }

    public void dZ(int i) {
        this.aDU = i;
    }

    public int Er() {
        return this.aDX;
    }

    public void ea(int i) {
        this.aDX = i;
    }

    public int Es() {
        return this.aDY;
    }

    public int Et() {
        return this.aEa;
    }

    public void eb(int i) {
        this.aEa = i;
    }

    public int Eu() {
        return this.aEe;
    }

    public void ec(int i) {
        this.aEe = i;
    }

    public int Ev() {
        return this.aEd;
    }

    public void ed(int i) {
        this.aEd = i;
    }

    public int Ew() {
        return this.aDU;
    }

    public int Ex() {
        return this.aDW;
    }

    public void ee(int i) {
        this.aDW = i;
    }

    public boolean Ey() {
        return this.aEk;
    }

    public void bp(boolean z) {
        this.aEk = z;
    }

    public String Ez() {
        return this.aEm;
    }

    public void fI(String str) {
        this.aEm = str;
    }

    public String EA() {
        return this.aEs;
    }

    public void fJ(String str) {
        this.aEs = str;
    }

    public void fK(String str) {
        this.aEt = str;
    }

    public int EB() {
        return this.aDV;
    }

    public void ef(int i) {
        this.aDV = i;
    }

    public void fL(String str) {
        this.aEu = str;
    }

    public String EC() {
        return this.aEw;
    }

    public String ED() {
        return this.aEx;
    }

    public HashMap<String, String> EE() {
        return this.aEq;
    }

    public int EF() {
        return this.aDZ;
    }

    public void eg(int i) {
        this.aDZ = i;
    }

    public int EG() {
        return this.aEb;
    }

    public void eh(int i) {
        this.aEb = i;
    }

    public int EH() {
        return this.aEf;
    }

    public void ei(int i) {
        this.aEf = i;
    }

    public void fM(String str) {
        this.aEn = str;
    }

    public void fN(String str) {
        this.aEo = str;
    }

    public int EI() {
        return this.aEc;
    }

    public void ej(int i) {
        this.aEc = i;
    }

    public String EJ() {
        return this.aEp;
    }

    public void fO(String str) {
        this.aEp = str;
    }

    public HashMap<String, String> EK() {
        return this.aEr;
    }

    public String EL() {
        return this.aEv;
    }

    public void fP(String str) {
        this.aEv = str;
    }

    public int EM() {
        return this.aEh;
    }

    public void ek(int i) {
        this.aEh = i;
    }

    public int EN() {
        return this.aEi;
    }

    public void el(int i) {
        this.aEi = i;
    }

    public List<a> EO() {
        return this.aEy;
    }

    public int EP() {
        return this.aEj;
    }

    public void em(int i) {
        this.aEj = i;
    }
}
