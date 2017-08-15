package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String auj;
    private String auk;
    private String aul;
    private String aum;
    private String aup;
    private String auq;
    private String aur;
    private String aus;
    private String aut;
    private String auu;
    private int atN = 0;
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
    private boolean auh = true;
    private boolean aui = true;
    private HashMap<String, String> aun = new HashMap<>();
    private HashMap<String, String> auo = new HashMap<>();
    private String auv = null;
    private String auw = null;
    private List<b> aux = new ArrayList();
    private List<a> auy = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int auA;
        public int auz;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int auA;
        public String auB;
        public String auC;
        public int auz;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Ag() {
        HashMap<String, String> Aw = Aw();
        Set<String> keySet = Aw.keySet();
        if (keySet.size() != 1) {
            eS(null);
        } else {
            eS(Aw.get(keySet.iterator().next()));
        }
    }

    public void Ah() {
        HashMap<String, String> AC = AC();
        Set<String> keySet = AC.keySet();
        if (keySet.size() != 1) {
            eY(null);
        } else {
            eY(AC.get(keySet.iterator().next()));
        }
    }

    public int Ai() {
        return this.atN;
    }

    public void dP(int i) {
        this.atN = i;
    }

    public int Aj() {
        return this.atQ;
    }

    public void dQ(int i) {
        this.atQ = i;
    }

    public int Ak() {
        return this.atR;
    }

    public int Al() {
        return this.atV;
    }

    public void dR(int i) {
        this.atV = i;
    }

    public int Am() {
        return this.atZ;
    }

    public void dS(int i) {
        this.atZ = i;
    }

    public int An() {
        return this.atY;
    }

    public void dT(int i) {
        this.atY = i;
    }

    public int Ao() {
        return this.atN;
    }

    public int Ap() {
        return this.atP;
    }

    public void dU(int i) {
        this.atP = i;
    }

    public boolean Aq() {
        return this.auh;
    }

    public void bk(boolean z) {
        this.auh = z;
    }

    public String Ar() {
        return this.auj;
    }

    public void eR(String str) {
        this.auj = str;
    }

    public String As() {
        return this.aup;
    }

    public void eS(String str) {
        this.aup = str;
    }

    public void eT(String str) {
        this.auq = str;
    }

    public int At() {
        return this.atO;
    }

    public void dV(int i) {
        this.atO = i;
    }

    public void eU(String str) {
        this.aur = str;
    }

    public String Au() {
        return this.aut;
    }

    public String Av() {
        return this.auu;
    }

    public HashMap<String, String> Aw() {
        return this.aun;
    }

    public int Ax() {
        return this.atS;
    }

    public void dW(int i) {
        this.atS = i;
    }

    public int Ay() {
        return this.atW;
    }

    public void dX(int i) {
        this.atW = i;
    }

    public int Az() {
        return this.aua;
    }

    public void dY(int i) {
        this.aua = i;
    }

    public void eV(String str) {
        this.auk = str;
    }

    public void eW(String str) {
        this.aul = str;
    }

    public int AA() {
        return this.atX;
    }

    public void dZ(int i) {
        this.atX = i;
    }

    public String AB() {
        return this.aum;
    }

    public void eX(String str) {
        this.aum = str;
    }

    public HashMap<String, String> AC() {
        return this.auo;
    }

    public String AD() {
        return this.aus;
    }

    public void eY(String str) {
        this.aus = str;
    }

    public int AE() {
        return this.atT;
    }

    public int AF() {
        return this.atU;
    }

    public void ea(int i) {
        this.atT = i;
    }

    public void eb(int i) {
        this.atU = i;
    }

    public void eZ(String str) {
        this.auv = str;
    }

    public void fa(String str) {
        this.auw = str;
    }

    public int AG() {
        return this.auc;
    }

    public void ec(int i) {
        this.auc = i;
    }

    public int AH() {
        return this.aud;
    }

    public void ed(int i) {
        this.aud = i;
    }

    public int AI() {
        return this.aue;
    }

    public void ee(int i) {
        this.aue = i;
    }

    public int AJ() {
        return this.auf;
    }

    public void ef(int i) {
        this.auf = i;
    }

    public List<b> AK() {
        return this.aux;
    }

    public List<a> AL() {
        return this.auy;
    }

    public int AM() {
        return this.aug;
    }

    public void eg(int i) {
        this.aug = i;
    }
}
