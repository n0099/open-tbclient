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

    public void EG() {
        HashMap<String, String> EW = EW();
        Set<String> keySet = EW.keySet();
        if (keySet.size() != 1) {
            fN(null);
        } else {
            fN(EW.get(keySet.iterator().next()));
        }
    }

    public void EH() {
        HashMap<String, String> Fc = Fc();
        Set<String> keySet = Fc.keySet();
        if (keySet.size() != 1) {
            fT(null);
        } else {
            fT(Fc.get(keySet.iterator().next()));
        }
    }

    public int EI() {
        return this.aEO;
    }

    public void ea(int i) {
        this.aEO = i;
    }

    public int EJ() {
        return this.aER;
    }

    public void eb(int i) {
        this.aER = i;
    }

    public int EK() {
        return this.aES;
    }

    public int EL() {
        return this.aEU;
    }

    public void ec(int i) {
        this.aEU = i;
    }

    public int EM() {
        return this.aEY;
    }

    public void ed(int i) {
        this.aEY = i;
    }

    public int EN() {
        return this.aEX;
    }

    public void ee(int i) {
        this.aEX = i;
    }

    public int EO() {
        return this.aEO;
    }

    public int EP() {
        return this.aEQ;
    }

    public void ef(int i) {
        this.aEQ = i;
    }

    public boolean EQ() {
        return this.aFe;
    }

    public void bs(boolean z) {
        this.aFe = z;
    }

    public String ER() {
        return this.aFg;
    }

    public void fM(String str) {
        this.aFg = str;
    }

    public String ES() {
        return this.aFm;
    }

    public void fN(String str) {
        this.aFm = str;
    }

    public void fO(String str) {
        this.aFn = str;
    }

    public int ET() {
        return this.aEP;
    }

    public void eg(int i) {
        this.aEP = i;
    }

    public void fP(String str) {
        this.aFo = str;
    }

    public String EU() {
        return this.aFq;
    }

    public String EV() {
        return this.aFr;
    }

    public HashMap<String, String> EW() {
        return this.aFk;
    }

    public int EX() {
        return this.aET;
    }

    public void eh(int i) {
        this.aET = i;
    }

    public int EY() {
        return this.aEV;
    }

    public void ei(int i) {
        this.aEV = i;
    }

    public int EZ() {
        return this.aEZ;
    }

    public void ej(int i) {
        this.aEZ = i;
    }

    public void fQ(String str) {
        this.aFh = str;
    }

    public void fR(String str) {
        this.aFi = str;
    }

    public int Fa() {
        return this.aEW;
    }

    public void ek(int i) {
        this.aEW = i;
    }

    public String Fb() {
        return this.aFj;
    }

    public void fS(String str) {
        this.aFj = str;
    }

    public HashMap<String, String> Fc() {
        return this.aFl;
    }

    public String Fd() {
        return this.aFp;
    }

    public void fT(String str) {
        this.aFp = str;
    }

    public int Fe() {
        return this.aFb;
    }

    public void el(int i) {
        this.aFb = i;
    }

    public int Ff() {
        return this.aFc;
    }

    public void em(int i) {
        this.aFc = i;
    }

    public List<a> Fg() {
        return this.aFs;
    }

    public int Fh() {
        return this.aFd;
    }

    public void en(int i) {
        this.aFd = i;
    }
}
