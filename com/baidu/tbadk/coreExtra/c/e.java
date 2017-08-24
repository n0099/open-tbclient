package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String auk;
    private String aul;
    private String aum;
    private String aun;
    private String auq;
    private String aur;
    private String aus;
    private String aut;
    private String auu;
    private String auv;
    private int atO = 0;
    private int atP = 0;
    private int atQ = 0;
    private int atR = 0;
    private int atS = 0;
    private int atT = 0;
    private int atU = 0;
    private int atV = 0;
    private int atW = 0;
    private int atX = 0;
    private int atY = 0;
    private int atZ = 0;
    private int aua = 0;
    private int aub = 0;
    private int auc = 0;
    private int aud = 0;
    private int aue = 0;
    private int auf = 0;
    private int aug = 0;
    private int auh = 0;
    private boolean aui = true;
    private boolean auj = true;
    private HashMap<String, String> auo = new HashMap<>();
    private HashMap<String, String> aup = new HashMap<>();
    private String auw = null;
    private String aux = null;
    private List<b> auy = new ArrayList();
    private List<a> auz = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int auA;
        public int auB;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int auA;
        public int auB;
        public String auC;
        public String auD;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Ag() {
        HashMap<String, String> Aw = Aw();
        Set<String> keySet = Aw.keySet();
        if (keySet.size() != 1) {
            eW(null);
        } else {
            eW(Aw.get(keySet.iterator().next()));
        }
    }

    public void Ah() {
        HashMap<String, String> AC = AC();
        Set<String> keySet = AC.keySet();
        if (keySet.size() != 1) {
            fc(null);
        } else {
            fc(AC.get(keySet.iterator().next()));
        }
    }

    public int Ai() {
        return this.atO;
    }

    public void dP(int i) {
        this.atO = i;
    }

    public int Aj() {
        return this.atR;
    }

    public void dQ(int i) {
        this.atR = i;
    }

    public int Ak() {
        return this.atS;
    }

    public int Al() {
        return this.atW;
    }

    public void dR(int i) {
        this.atW = i;
    }

    public int Am() {
        return this.aua;
    }

    public void dS(int i) {
        this.aua = i;
    }

    public int An() {
        return this.atZ;
    }

    public void dT(int i) {
        this.atZ = i;
    }

    public int Ao() {
        return this.atO;
    }

    public int Ap() {
        return this.atQ;
    }

    public void dU(int i) {
        this.atQ = i;
    }

    public boolean Aq() {
        return this.aui;
    }

    public void bk(boolean z) {
        this.aui = z;
    }

    public String Ar() {
        return this.auk;
    }

    public void eV(String str) {
        this.auk = str;
    }

    public String As() {
        return this.auq;
    }

    public void eW(String str) {
        this.auq = str;
    }

    public void eX(String str) {
        this.aur = str;
    }

    public int At() {
        return this.atP;
    }

    public void dV(int i) {
        this.atP = i;
    }

    public void eY(String str) {
        this.aus = str;
    }

    public String Au() {
        return this.auu;
    }

    public String Av() {
        return this.auv;
    }

    public HashMap<String, String> Aw() {
        return this.auo;
    }

    public int Ax() {
        return this.atT;
    }

    public void dW(int i) {
        this.atT = i;
    }

    public int Ay() {
        return this.atX;
    }

    public void dX(int i) {
        this.atX = i;
    }

    public int Az() {
        return this.aub;
    }

    public void dY(int i) {
        this.aub = i;
    }

    public void eZ(String str) {
        this.aul = str;
    }

    public void fa(String str) {
        this.aum = str;
    }

    public int AA() {
        return this.atY;
    }

    public void dZ(int i) {
        this.atY = i;
    }

    public String AB() {
        return this.aun;
    }

    public void fb(String str) {
        this.aun = str;
    }

    public HashMap<String, String> AC() {
        return this.aup;
    }

    public String AD() {
        return this.aut;
    }

    public void fc(String str) {
        this.aut = str;
    }

    public int AE() {
        return this.atU;
    }

    public int AF() {
        return this.atV;
    }

    public void ea(int i) {
        this.atU = i;
    }

    public void eb(int i) {
        this.atV = i;
    }

    public void fd(String str) {
        this.auw = str;
    }

    public void fe(String str) {
        this.aux = str;
    }

    public int AG() {
        return this.aud;
    }

    public void ec(int i) {
        this.aud = i;
    }

    public int AH() {
        return this.aue;
    }

    public void ed(int i) {
        this.aue = i;
    }

    public int AI() {
        return this.auf;
    }

    public void ee(int i) {
        this.auf = i;
    }

    public int AJ() {
        return this.aug;
    }

    public void ef(int i) {
        this.aug = i;
    }

    public List<b> AK() {
        return this.auy;
    }

    public List<a> AL() {
        return this.auz;
    }

    public int AM() {
        return this.auh;
    }

    public void eg(int i) {
        this.auh = i;
    }
}
