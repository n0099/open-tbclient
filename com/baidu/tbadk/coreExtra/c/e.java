package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aui;
    private String auj;
    private String auk;
    private String aul;
    private String auo;
    private String aup;
    private String auq;
    private String aur;
    private String aus;
    private String aut;
    private int atM = 0;
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
    private boolean aug = true;
    private boolean auh = true;
    private HashMap<String, String> aum = new HashMap<>();
    private HashMap<String, String> aun = new HashMap<>();
    private String auu = null;
    private String auv = null;
    private List<b> auw = new ArrayList();
    private List<a> aux = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int auy;
        public int auz;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public String auA;
        public String auB;
        public int auy;
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
        return this.atM;
    }

    public void dP(int i) {
        this.atM = i;
    }

    public int Aj() {
        return this.atP;
    }

    public void dQ(int i) {
        this.atP = i;
    }

    public int Ak() {
        return this.atQ;
    }

    public int Al() {
        return this.atU;
    }

    public void dR(int i) {
        this.atU = i;
    }

    public int Am() {
        return this.atY;
    }

    public void dS(int i) {
        this.atY = i;
    }

    public int An() {
        return this.atX;
    }

    public void dT(int i) {
        this.atX = i;
    }

    public int Ao() {
        return this.atM;
    }

    public int Ap() {
        return this.atO;
    }

    public void dU(int i) {
        this.atO = i;
    }

    public boolean Aq() {
        return this.aug;
    }

    public void bk(boolean z) {
        this.aug = z;
    }

    public String Ar() {
        return this.aui;
    }

    public void eR(String str) {
        this.aui = str;
    }

    public String As() {
        return this.auo;
    }

    public void eS(String str) {
        this.auo = str;
    }

    public void eT(String str) {
        this.aup = str;
    }

    public int At() {
        return this.atN;
    }

    public void dV(int i) {
        this.atN = i;
    }

    public void eU(String str) {
        this.auq = str;
    }

    public String Au() {
        return this.aus;
    }

    public String Av() {
        return this.aut;
    }

    public HashMap<String, String> Aw() {
        return this.aum;
    }

    public int Ax() {
        return this.atR;
    }

    public void dW(int i) {
        this.atR = i;
    }

    public int Ay() {
        return this.atV;
    }

    public void dX(int i) {
        this.atV = i;
    }

    public int Az() {
        return this.atZ;
    }

    public void dY(int i) {
        this.atZ = i;
    }

    public void eV(String str) {
        this.auj = str;
    }

    public void eW(String str) {
        this.auk = str;
    }

    public int AA() {
        return this.atW;
    }

    public void dZ(int i) {
        this.atW = i;
    }

    public String AB() {
        return this.aul;
    }

    public void eX(String str) {
        this.aul = str;
    }

    public HashMap<String, String> AC() {
        return this.aun;
    }

    public String AD() {
        return this.aur;
    }

    public void eY(String str) {
        this.aur = str;
    }

    public int AE() {
        return this.atS;
    }

    public int AF() {
        return this.atT;
    }

    public void ea(int i) {
        this.atS = i;
    }

    public void eb(int i) {
        this.atT = i;
    }

    public void eZ(String str) {
        this.auu = str;
    }

    public void fa(String str) {
        this.auv = str;
    }

    public int AG() {
        return this.aub;
    }

    public void ec(int i) {
        this.aub = i;
    }

    public int AH() {
        return this.auc;
    }

    public void ed(int i) {
        this.auc = i;
    }

    public int AI() {
        return this.aud;
    }

    public void ee(int i) {
        this.aud = i;
    }

    public int AJ() {
        return this.aue;
    }

    public void ef(int i) {
        this.aue = i;
    }

    public List<b> AK() {
        return this.auw;
    }

    public List<a> AL() {
        return this.aux;
    }

    public int AM() {
        return this.auf;
    }

    public void eg(int i) {
        this.auf = i;
    }
}
