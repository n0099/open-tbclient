package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String asQ;
    private String asR;
    private String asS;
    private String asT;
    private String asW;
    private String asX;
    private String asY;
    private String asZ;
    private String ata;
    private String atb;
    private int asu = 0;
    private int asv = 0;
    private int asw = 0;
    private int asx = 0;
    private int asy = 0;
    private int asz = 0;
    private int asA = 0;
    private int asB = 0;
    private int asC = 0;
    private int asD = 0;
    private int asE = 0;
    private int asF = 0;
    private int asG = 0;
    private int asH = 0;
    private int asI = 0;
    private int asJ = 0;
    private int asK = 0;
    private int asL = 0;
    private int asM = 0;
    private int asN = 0;
    private boolean asO = true;
    private boolean asP = true;
    private HashMap<String, String> asU = new HashMap<>();
    private HashMap<String, String> asV = new HashMap<>();
    private String atc = null;
    private String atd = null;
    private List<b> ate = new ArrayList();
    private List<a> atf = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int atg;
        public int ath;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int atg;
        public int ath;
        public String ati;
        public String atj;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zY() {
        HashMap<String, String> Ao = Ao();
        Set<String> keySet = Ao.keySet();
        if (keySet.size() != 1) {
            eM(null);
        } else {
            eM(Ao.get(keySet.iterator().next()));
        }
    }

    public void zZ() {
        HashMap<String, String> Au = Au();
        Set<String> keySet = Au.keySet();
        if (keySet.size() != 1) {
            eS(null);
        } else {
            eS(Au.get(keySet.iterator().next()));
        }
    }

    public int Aa() {
        return this.asu;
    }

    public void dN(int i) {
        this.asu = i;
    }

    public int Ab() {
        return this.asx;
    }

    public void dO(int i) {
        this.asx = i;
    }

    public int Ac() {
        return this.asy;
    }

    public int Ad() {
        return this.asC;
    }

    public void dP(int i) {
        this.asC = i;
    }

    public int Ae() {
        return this.asG;
    }

    public void dQ(int i) {
        this.asG = i;
    }

    public int Af() {
        return this.asF;
    }

    public void dR(int i) {
        this.asF = i;
    }

    public int Ag() {
        return this.asu;
    }

    public int Ah() {
        return this.asw;
    }

    public void dS(int i) {
        this.asw = i;
    }

    public boolean Ai() {
        return this.asO;
    }

    public void bk(boolean z) {
        this.asO = z;
    }

    public String Aj() {
        return this.asQ;
    }

    public void eL(String str) {
        this.asQ = str;
    }

    public String Ak() {
        return this.asW;
    }

    public void eM(String str) {
        this.asW = str;
    }

    public void eN(String str) {
        this.asX = str;
    }

    public int Al() {
        return this.asv;
    }

    public void dT(int i) {
        this.asv = i;
    }

    public void eO(String str) {
        this.asY = str;
    }

    public String Am() {
        return this.ata;
    }

    public String An() {
        return this.atb;
    }

    public HashMap<String, String> Ao() {
        return this.asU;
    }

    public int Ap() {
        return this.asz;
    }

    public void dU(int i) {
        this.asz = i;
    }

    public int Aq() {
        return this.asD;
    }

    public void dV(int i) {
        this.asD = i;
    }

    public int Ar() {
        return this.asH;
    }

    public void dW(int i) {
        this.asH = i;
    }

    public void eP(String str) {
        this.asR = str;
    }

    public void eQ(String str) {
        this.asS = str;
    }

    public int As() {
        return this.asE;
    }

    public void dX(int i) {
        this.asE = i;
    }

    public String At() {
        return this.asT;
    }

    public void eR(String str) {
        this.asT = str;
    }

    public HashMap<String, String> Au() {
        return this.asV;
    }

    public String Av() {
        return this.asZ;
    }

    public void eS(String str) {
        this.asZ = str;
    }

    public int Aw() {
        return this.asA;
    }

    public int Ax() {
        return this.asB;
    }

    public void dY(int i) {
        this.asA = i;
    }

    public void dZ(int i) {
        this.asB = i;
    }

    public void eT(String str) {
        this.atc = str;
    }

    public void eU(String str) {
        this.atd = str;
    }

    public int Ay() {
        return this.asJ;
    }

    public void ea(int i) {
        this.asJ = i;
    }

    public int Az() {
        return this.asK;
    }

    public void eb(int i) {
        this.asK = i;
    }

    public int AA() {
        return this.asL;
    }

    public void ec(int i) {
        this.asL = i;
    }

    public int AB() {
        return this.asM;
    }

    public void ed(int i) {
        this.asM = i;
    }

    public List<b> AC() {
        return this.ate;
    }

    public List<a> AD() {
        return this.atf;
    }

    public int AE() {
        return this.asN;
    }

    public void ee(int i) {
        this.asN = i;
    }
}
