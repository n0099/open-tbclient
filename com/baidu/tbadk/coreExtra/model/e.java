package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String atE;
    private String atF;
    private String atG;
    private String atH;
    private String atK;
    private String atL;
    private String atM;
    private String atN;
    private String atO;
    private String atP;
    private int ati = 0;
    private int atj = 0;
    private int atk = 0;
    private int atl = 0;
    private int atm = 0;
    private int atn = 0;
    private int ato = 0;
    private int atp = 0;
    private int atq = 0;
    private int atr = 0;
    private int ats = 0;
    private int att = 0;
    private int atu = 0;
    private int atv = 0;
    private int atw = 0;
    private int atx = 0;
    private int aty = 0;
    private int atz = 0;
    private int atA = 0;
    private int atB = 0;
    private boolean atC = true;
    private boolean atD = true;
    private HashMap<String, String> atI = new HashMap<>();
    private HashMap<String, String> atJ = new HashMap<>();
    private String atQ = null;
    private String atR = null;
    private List<b> atS = new ArrayList();
    private List<a> atT = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int atU;
        public int atV;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int atU;
        public int atV;
        public String atW;
        public String atX;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zV() {
        HashMap<String, String> Al = Al();
        Set<String> keySet = Al.keySet();
        if (keySet.size() != 1) {
            eV(null);
        } else {
            eV(Al.get(keySet.iterator().next()));
        }
    }

    public void zW() {
        HashMap<String, String> Ar = Ar();
        Set<String> keySet = Ar.keySet();
        if (keySet.size() != 1) {
            fb(null);
        } else {
            fb(Ar.get(keySet.iterator().next()));
        }
    }

    public int zX() {
        return this.ati;
    }

    public void ea(int i) {
        this.ati = i;
    }

    public int zY() {
        return this.atl;
    }

    public void eb(int i) {
        this.atl = i;
    }

    public int zZ() {
        return this.atm;
    }

    public int Aa() {
        return this.atq;
    }

    public void ec(int i) {
        this.atq = i;
    }

    public int Ab() {
        return this.atu;
    }

    public void ed(int i) {
        this.atu = i;
    }

    public int Ac() {
        return this.att;
    }

    public void ee(int i) {
        this.att = i;
    }

    public int Ad() {
        return this.ati;
    }

    public int Ae() {
        return this.atk;
    }

    public void ef(int i) {
        this.atk = i;
    }

    public boolean Af() {
        return this.atC;
    }

    public void bh(boolean z) {
        this.atC = z;
    }

    public String Ag() {
        return this.atE;
    }

    public void eU(String str) {
        this.atE = str;
    }

    public String Ah() {
        return this.atK;
    }

    public void eV(String str) {
        this.atK = str;
    }

    public void eW(String str) {
        this.atL = str;
    }

    public int Ai() {
        return this.atj;
    }

    public void eg(int i) {
        this.atj = i;
    }

    public void eX(String str) {
        this.atM = str;
    }

    public String Aj() {
        return this.atO;
    }

    public String Ak() {
        return this.atP;
    }

    public HashMap<String, String> Al() {
        return this.atI;
    }

    public int Am() {
        return this.atn;
    }

    public void eh(int i) {
        this.atn = i;
    }

    public int An() {
        return this.atr;
    }

    public void ei(int i) {
        this.atr = i;
    }

    public int Ao() {
        return this.atv;
    }

    public void ej(int i) {
        this.atv = i;
    }

    public void eY(String str) {
        this.atF = str;
    }

    public void eZ(String str) {
        this.atG = str;
    }

    public int Ap() {
        return this.ats;
    }

    public void ek(int i) {
        this.ats = i;
    }

    public String Aq() {
        return this.atH;
    }

    public void fa(String str) {
        this.atH = str;
    }

    public HashMap<String, String> Ar() {
        return this.atJ;
    }

    public String As() {
        return this.atN;
    }

    public void fb(String str) {
        this.atN = str;
    }

    public int At() {
        return this.ato;
    }

    public int Au() {
        return this.atp;
    }

    public void el(int i) {
        this.ato = i;
    }

    public void em(int i) {
        this.atp = i;
    }

    public void fc(String str) {
        this.atQ = str;
    }

    public void fd(String str) {
        this.atR = str;
    }

    public int Av() {
        return this.atx;
    }

    public void en(int i) {
        this.atx = i;
    }

    public int Aw() {
        return this.aty;
    }

    public void eo(int i) {
        this.aty = i;
    }

    public int Ax() {
        return this.atz;
    }

    public void ep(int i) {
        this.atz = i;
    }

    public int Ay() {
        return this.atA;
    }

    public void eq(int i) {
        this.atA = i;
    }

    public List<b> Az() {
        return this.atS;
    }

    public List<a> AA() {
        return this.atT;
    }

    public int AB() {
        return this.atB;
    }

    public void er(int i) {
        this.atB = i;
    }
}
