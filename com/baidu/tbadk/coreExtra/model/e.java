package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aFg;
    private String aFh;
    private String aFi;
    private String aFj;
    private String aFm;
    private String aFn;
    private String aFo;
    private String aFp;
    private String aFq;
    private String aFr;
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
    private int aFd = 0;
    private boolean aFe = true;
    private boolean aFf = true;
    private HashMap<String, String> aFk = new HashMap<>();
    private HashMap<String, String> aFl = new HashMap<>();
    private List<a> aFs = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aFt;
        public String aFu;
        public int aFv;
        public String aFw;
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
        return this.aEO;
    }

    public void ed(int i) {
        this.aEO = i;
    }

    public int EF() {
        return this.aER;
    }

    public void ee(int i) {
        this.aER = i;
    }

    public int EG() {
        return this.aES;
    }

    public int EH() {
        return this.aEU;
    }

    public void ef(int i) {
        this.aEU = i;
    }

    public int EI() {
        return this.aEY;
    }

    public void eg(int i) {
        this.aEY = i;
    }

    public int EJ() {
        return this.aEX;
    }

    public void eh(int i) {
        this.aEX = i;
    }

    public int EK() {
        return this.aEO;
    }

    public int EL() {
        return this.aEQ;
    }

    public void ei(int i) {
        this.aEQ = i;
    }

    public boolean EM() {
        return this.aFe;
    }

    public void bq(boolean z) {
        this.aFe = z;
    }

    public String EN() {
        return this.aFg;
    }

    public void fK(String str) {
        this.aFg = str;
    }

    public String EO() {
        return this.aFm;
    }

    public void fL(String str) {
        this.aFm = str;
    }

    public void fM(String str) {
        this.aFn = str;
    }

    public int EP() {
        return this.aEP;
    }

    public void ej(int i) {
        this.aEP = i;
    }

    public void fN(String str) {
        this.aFo = str;
    }

    public String EQ() {
        return this.aFq;
    }

    public String ER() {
        return this.aFr;
    }

    public HashMap<String, String> ES() {
        return this.aFk;
    }

    public int ET() {
        return this.aET;
    }

    public void ek(int i) {
        this.aET = i;
    }

    public int EU() {
        return this.aEV;
    }

    public void el(int i) {
        this.aEV = i;
    }

    public int EV() {
        return this.aEZ;
    }

    public void em(int i) {
        this.aEZ = i;
    }

    public void fO(String str) {
        this.aFh = str;
    }

    public void fP(String str) {
        this.aFi = str;
    }

    public int EW() {
        return this.aEW;
    }

    public void en(int i) {
        this.aEW = i;
    }

    public String EX() {
        return this.aFj;
    }

    public void fQ(String str) {
        this.aFj = str;
    }

    public HashMap<String, String> EY() {
        return this.aFl;
    }

    public String EZ() {
        return this.aFp;
    }

    public void fR(String str) {
        this.aFp = str;
    }

    public int Fa() {
        return this.aFb;
    }

    public void eo(int i) {
        this.aFb = i;
    }

    public int Fb() {
        return this.aFc;
    }

    public void ep(int i) {
        this.aFc = i;
    }

    public List<a> Fc() {
        return this.aFs;
    }

    public int Fd() {
        return this.aFd;
    }

    public void eq(int i) {
        this.aFd = i;
    }
}
