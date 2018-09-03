package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aFf;
    private String aFg;
    private String aFh;
    private String aFi;
    private String aFl;
    private String aFm;
    private String aFn;
    private String aFo;
    private String aFp;
    private String aFq;
    private int aEN = 0;
    private int aEO = 0;
    private int aEP = 0;
    private int aEQ = 0;
    private int aER = 0;
    private int aES = 0;
    private int aET = 0;
    private int aEU = 0;
    private int aEV = 0;
    private int aEW = 0;
    private int aEX = 0;
    private int aEY = 0;
    private int aEZ = 0;
    private int aFa = 0;
    private int aFb = 0;
    private int aFc = 0;
    private boolean aFd = true;
    private boolean aFe = true;
    private HashMap<String, String> aFj = new HashMap<>();
    private HashMap<String, String> aFk = new HashMap<>();
    private List<a> aFr = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aFs;
        public String aFt;
        public int aFu;
        public String aFv;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void EC() {
        HashMap<String, String> ES = ES();
        Set<String> keySet = ES.keySet();
        if (keySet.size() != 1) {
            fL(null);
        } else {
            fL(ES.get(keySet.iterator().next()));
        }
    }

    public void ED() {
        HashMap<String, String> EY = EY();
        Set<String> keySet = EY.keySet();
        if (keySet.size() != 1) {
            fR(null);
        } else {
            fR(EY.get(keySet.iterator().next()));
        }
    }

    public int EE() {
        return this.aEN;
    }

    public void ec(int i) {
        this.aEN = i;
    }

    public int EF() {
        return this.aEQ;
    }

    public void ed(int i) {
        this.aEQ = i;
    }

    public int EG() {
        return this.aER;
    }

    public int EH() {
        return this.aET;
    }

    public void ee(int i) {
        this.aET = i;
    }

    public int EI() {
        return this.aEX;
    }

    public void ef(int i) {
        this.aEX = i;
    }

    public int EJ() {
        return this.aEW;
    }

    public void eg(int i) {
        this.aEW = i;
    }

    public int EK() {
        return this.aEN;
    }

    public int EL() {
        return this.aEP;
    }

    public void eh(int i) {
        this.aEP = i;
    }

    public boolean EM() {
        return this.aFd;
    }

    public void br(boolean z) {
        this.aFd = z;
    }

    public String EN() {
        return this.aFf;
    }

    public void fK(String str) {
        this.aFf = str;
    }

    public String EO() {
        return this.aFl;
    }

    public void fL(String str) {
        this.aFl = str;
    }

    public void fM(String str) {
        this.aFm = str;
    }

    public int EP() {
        return this.aEO;
    }

    public void ei(int i) {
        this.aEO = i;
    }

    public void fN(String str) {
        this.aFn = str;
    }

    public String EQ() {
        return this.aFp;
    }

    public String ER() {
        return this.aFq;
    }

    public HashMap<String, String> ES() {
        return this.aFj;
    }

    public int ET() {
        return this.aES;
    }

    public void ej(int i) {
        this.aES = i;
    }

    public int EU() {
        return this.aEU;
    }

    public void ek(int i) {
        this.aEU = i;
    }

    public int EV() {
        return this.aEY;
    }

    public void el(int i) {
        this.aEY = i;
    }

    public void fO(String str) {
        this.aFg = str;
    }

    public void fP(String str) {
        this.aFh = str;
    }

    public int EW() {
        return this.aEV;
    }

    public void em(int i) {
        this.aEV = i;
    }

    public String EX() {
        return this.aFi;
    }

    public void fQ(String str) {
        this.aFi = str;
    }

    public HashMap<String, String> EY() {
        return this.aFk;
    }

    public String EZ() {
        return this.aFo;
    }

    public void fR(String str) {
        this.aFo = str;
    }

    public int Fa() {
        return this.aFa;
    }

    public void en(int i) {
        this.aFa = i;
    }

    public int Fb() {
        return this.aFb;
    }

    public void eo(int i) {
        this.aFb = i;
    }

    public List<a> Fc() {
        return this.aFr;
    }

    public int Fd() {
        return this.aFc;
    }

    public void ep(int i) {
        this.aFc = i;
    }
}
