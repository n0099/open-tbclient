package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String atd;
    private String ate;
    private String atf;
    private String atg;
    private String atj;
    private String atk;
    private String atl;
    private String atm;
    private String atn;
    private String ato;
    private int asH = 0;
    private int asI = 0;
    private int asJ = 0;
    private int asK = 0;
    private int asL = 0;
    private int asM = 0;
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
    private boolean atb = true;
    private boolean atc = true;
    private HashMap<String, String> ath = new HashMap<>();
    private HashMap<String, String> ati = new HashMap<>();
    private String atp = null;
    private String atq = null;
    private List<b> atr = new ArrayList();
    private List<a> ats = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int att;
        public int atu;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int att;
        public int atu;
        public String atv;
        public String atw;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zJ() {
        HashMap<String, String> zZ = zZ();
        Set<String> keySet = zZ.keySet();
        if (keySet.size() != 1) {
            eQ(null);
        } else {
            eQ(zZ.get(keySet.iterator().next()));
        }
    }

    public void zK() {
        HashMap<String, String> Af = Af();
        Set<String> keySet = Af.keySet();
        if (keySet.size() != 1) {
            eW(null);
        } else {
            eW(Af.get(keySet.iterator().next()));
        }
    }

    public int zL() {
        return this.asH;
    }

    public void ea(int i) {
        this.asH = i;
    }

    public int zM() {
        return this.asK;
    }

    public void eb(int i) {
        this.asK = i;
    }

    public int zN() {
        return this.asL;
    }

    public int zO() {
        return this.asP;
    }

    public void ec(int i) {
        this.asP = i;
    }

    public int zP() {
        return this.asT;
    }

    public void ed(int i) {
        this.asT = i;
    }

    public int zQ() {
        return this.asS;
    }

    public void ee(int i) {
        this.asS = i;
    }

    public int zR() {
        return this.asH;
    }

    public int zS() {
        return this.asJ;
    }

    public void ef(int i) {
        this.asJ = i;
    }

    public boolean zT() {
        return this.atb;
    }

    public void bg(boolean z) {
        this.atb = z;
    }

    public String zU() {
        return this.atd;
    }

    public void eP(String str) {
        this.atd = str;
    }

    public String zV() {
        return this.atj;
    }

    public void eQ(String str) {
        this.atj = str;
    }

    public void eR(String str) {
        this.atk = str;
    }

    public int zW() {
        return this.asI;
    }

    public void eg(int i) {
        this.asI = i;
    }

    public void eS(String str) {
        this.atl = str;
    }

    public String zX() {
        return this.atn;
    }

    public String zY() {
        return this.ato;
    }

    public HashMap<String, String> zZ() {
        return this.ath;
    }

    public int Aa() {
        return this.asM;
    }

    public void eh(int i) {
        this.asM = i;
    }

    public int Ab() {
        return this.asQ;
    }

    public void ei(int i) {
        this.asQ = i;
    }

    public int Ac() {
        return this.asU;
    }

    public void ej(int i) {
        this.asU = i;
    }

    public void eT(String str) {
        this.ate = str;
    }

    public void eU(String str) {
        this.atf = str;
    }

    public int Ad() {
        return this.asR;
    }

    public void ek(int i) {
        this.asR = i;
    }

    public String Ae() {
        return this.atg;
    }

    public void eV(String str) {
        this.atg = str;
    }

    public HashMap<String, String> Af() {
        return this.ati;
    }

    public String Ag() {
        return this.atm;
    }

    public void eW(String str) {
        this.atm = str;
    }

    public int Ah() {
        return this.asN;
    }

    public int Ai() {
        return this.asO;
    }

    public void el(int i) {
        this.asN = i;
    }

    public void em(int i) {
        this.asO = i;
    }

    public void eX(String str) {
        this.atp = str;
    }

    public void eY(String str) {
        this.atq = str;
    }

    public int Aj() {
        return this.asW;
    }

    public void en(int i) {
        this.asW = i;
    }

    public int Ak() {
        return this.asX;
    }

    public void eo(int i) {
        this.asX = i;
    }

    public int Al() {
        return this.asY;
    }

    public void ep(int i) {
        this.asY = i;
    }

    public int Am() {
        return this.asZ;
    }

    public void eq(int i) {
        this.asZ = i;
    }

    public List<b> An() {
        return this.atr;
    }

    public List<a> Ao() {
        return this.ats;
    }

    public int Ap() {
        return this.ata;
    }

    public void er(int i) {
        this.ata = i;
    }
}
