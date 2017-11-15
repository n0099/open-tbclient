package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String atj;
    private String atk;
    private String atl;
    private String atm;
    private String atp;
    private String atq;
    private String atr;
    private String ats;
    private String att;
    private String atu;
    private int asN = 0;
    private int asO = 0;
    private int asP = 0;
    private int asQ = 0;
    private int asR = 0;
    private int asS = 0;
    private int asT = 0;
    private int asU = 0;
    private int asV = 0;
    private int asW = 0;
    private int asX = 0;
    private int asY = 0;
    private int asZ = 0;
    private int ata = 0;
    private int atb = 0;
    private int atc = 0;
    private int atd = 0;
    private int ate = 0;
    private int atf = 0;
    private int atg = 0;
    private boolean ath = true;
    private boolean ati = true;
    private HashMap<String, String> atn = new HashMap<>();
    private HashMap<String, String> ato = new HashMap<>();
    private String atv = null;
    private String atw = null;
    private List<b> atx = new ArrayList();
    private List<a> aty = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int atA;
        public int atz;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int atA;
        public String atB;
        public String atC;
        public int atz;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zR() {
        HashMap<String, String> Ah = Ah();
        Set<String> keySet = Ah.keySet();
        if (keySet.size() != 1) {
            eQ(null);
        } else {
            eQ(Ah.get(keySet.iterator().next()));
        }
    }

    public void zS() {
        HashMap<String, String> An = An();
        Set<String> keySet = An.keySet();
        if (keySet.size() != 1) {
            eW(null);
        } else {
            eW(An.get(keySet.iterator().next()));
        }
    }

    public int zT() {
        return this.asN;
    }

    public void dZ(int i) {
        this.asN = i;
    }

    public int zU() {
        return this.asQ;
    }

    public void ea(int i) {
        this.asQ = i;
    }

    public int zV() {
        return this.asR;
    }

    public int zW() {
        return this.asV;
    }

    public void eb(int i) {
        this.asV = i;
    }

    public int zX() {
        return this.asZ;
    }

    public void ec(int i) {
        this.asZ = i;
    }

    public int zY() {
        return this.asY;
    }

    public void ed(int i) {
        this.asY = i;
    }

    public int zZ() {
        return this.asN;
    }

    public int Aa() {
        return this.asP;
    }

    public void ee(int i) {
        this.asP = i;
    }

    public boolean Ab() {
        return this.ath;
    }

    public void bh(boolean z) {
        this.ath = z;
    }

    public String Ac() {
        return this.atj;
    }

    public void eP(String str) {
        this.atj = str;
    }

    public String Ad() {
        return this.atp;
    }

    public void eQ(String str) {
        this.atp = str;
    }

    public void eR(String str) {
        this.atq = str;
    }

    public int Ae() {
        return this.asO;
    }

    public void ef(int i) {
        this.asO = i;
    }

    public void eS(String str) {
        this.atr = str;
    }

    public String Af() {
        return this.att;
    }

    public String Ag() {
        return this.atu;
    }

    public HashMap<String, String> Ah() {
        return this.atn;
    }

    public int Ai() {
        return this.asS;
    }

    public void eg(int i) {
        this.asS = i;
    }

    public int Aj() {
        return this.asW;
    }

    public void eh(int i) {
        this.asW = i;
    }

    public int Ak() {
        return this.ata;
    }

    public void ei(int i) {
        this.ata = i;
    }

    public void eT(String str) {
        this.atk = str;
    }

    public void eU(String str) {
        this.atl = str;
    }

    public int Al() {
        return this.asX;
    }

    public void ej(int i) {
        this.asX = i;
    }

    public String Am() {
        return this.atm;
    }

    public void eV(String str) {
        this.atm = str;
    }

    public HashMap<String, String> An() {
        return this.ato;
    }

    public String Ao() {
        return this.ats;
    }

    public void eW(String str) {
        this.ats = str;
    }

    public int Ap() {
        return this.asT;
    }

    public int Aq() {
        return this.asU;
    }

    public void ek(int i) {
        this.asT = i;
    }

    public void el(int i) {
        this.asU = i;
    }

    public void eX(String str) {
        this.atv = str;
    }

    public void eY(String str) {
        this.atw = str;
    }

    public int Ar() {
        return this.atc;
    }

    public void em(int i) {
        this.atc = i;
    }

    public int As() {
        return this.atd;
    }

    public void en(int i) {
        this.atd = i;
    }

    public int At() {
        return this.ate;
    }

    public void eo(int i) {
        this.ate = i;
    }

    public int Au() {
        return this.atf;
    }

    public void ep(int i) {
        this.atf = i;
    }

    public List<b> Av() {
        return this.atx;
    }

    public List<a> Aw() {
        return this.aty;
    }

    public int Ax() {
        return this.atg;
    }

    public void eq(int i) {
        this.atg = i;
    }
}
