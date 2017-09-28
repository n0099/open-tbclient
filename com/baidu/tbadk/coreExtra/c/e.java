package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String asW;
    private String asX;
    private String asY;
    private String asZ;
    private String atc;
    private String atd;
    private String ate;
    private String atf;
    private String atg;
    private String ath;
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
    private int asO = 0;
    private int asP = 0;
    private int asQ = 0;
    private int asR = 0;
    private int asS = 0;
    private int asT = 0;
    private boolean asU = true;
    private boolean asV = true;
    private HashMap<String, String> ata = new HashMap<>();
    private HashMap<String, String> atb = new HashMap<>();
    private String ati = null;
    private String atj = null;
    private List<b> atk = new ArrayList();
    private List<a> atl = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int atm;
        public int atn;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int atm;
        public int atn;
        public String ato;
        public String atp;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zI() {
        HashMap<String, String> zY = zY();
        Set<String> keySet = zY.keySet();
        if (keySet.size() != 1) {
            eK(null);
        } else {
            eK(zY.get(keySet.iterator().next()));
        }
    }

    public void zJ() {
        HashMap<String, String> Ae = Ae();
        Set<String> keySet = Ae.keySet();
        if (keySet.size() != 1) {
            eQ(null);
        } else {
            eQ(Ae.get(keySet.iterator().next()));
        }
    }

    public int zK() {
        return this.asA;
    }

    public void ea(int i) {
        this.asA = i;
    }

    public int zL() {
        return this.asD;
    }

    public void eb(int i) {
        this.asD = i;
    }

    public int zM() {
        return this.asE;
    }

    public int zN() {
        return this.asI;
    }

    public void ec(int i) {
        this.asI = i;
    }

    public int zO() {
        return this.asM;
    }

    public void ed(int i) {
        this.asM = i;
    }

    public int zP() {
        return this.asL;
    }

    public void ee(int i) {
        this.asL = i;
    }

    public int zQ() {
        return this.asA;
    }

    public int zR() {
        return this.asC;
    }

    public void ef(int i) {
        this.asC = i;
    }

    public boolean zS() {
        return this.asU;
    }

    public void bj(boolean z) {
        this.asU = z;
    }

    public String zT() {
        return this.asW;
    }

    public void eJ(String str) {
        this.asW = str;
    }

    public String zU() {
        return this.atc;
    }

    public void eK(String str) {
        this.atc = str;
    }

    public void eL(String str) {
        this.atd = str;
    }

    public int zV() {
        return this.asB;
    }

    public void eg(int i) {
        this.asB = i;
    }

    public void eM(String str) {
        this.ate = str;
    }

    public String zW() {
        return this.atg;
    }

    public String zX() {
        return this.ath;
    }

    public HashMap<String, String> zY() {
        return this.ata;
    }

    public int zZ() {
        return this.asF;
    }

    public void eh(int i) {
        this.asF = i;
    }

    public int Aa() {
        return this.asJ;
    }

    public void ei(int i) {
        this.asJ = i;
    }

    public int Ab() {
        return this.asN;
    }

    public void ej(int i) {
        this.asN = i;
    }

    public void eN(String str) {
        this.asX = str;
    }

    public void eO(String str) {
        this.asY = str;
    }

    public int Ac() {
        return this.asK;
    }

    public void ek(int i) {
        this.asK = i;
    }

    public String Ad() {
        return this.asZ;
    }

    public void eP(String str) {
        this.asZ = str;
    }

    public HashMap<String, String> Ae() {
        return this.atb;
    }

    public String Af() {
        return this.atf;
    }

    public void eQ(String str) {
        this.atf = str;
    }

    public int Ag() {
        return this.asG;
    }

    public int Ah() {
        return this.asH;
    }

    public void el(int i) {
        this.asG = i;
    }

    public void em(int i) {
        this.asH = i;
    }

    public void eR(String str) {
        this.ati = str;
    }

    public void eS(String str) {
        this.atj = str;
    }

    public int Ai() {
        return this.asP;
    }

    public void en(int i) {
        this.asP = i;
    }

    public int Aj() {
        return this.asQ;
    }

    public void eo(int i) {
        this.asQ = i;
    }

    public int Ak() {
        return this.asR;
    }

    public void ep(int i) {
        this.asR = i;
    }

    public int Al() {
        return this.asS;
    }

    public void eq(int i) {
        this.asS = i;
    }

    public List<b> Am() {
        return this.atk;
    }

    public List<a> An() {
        return this.atl;
    }

    public int Ao() {
        return this.asT;
    }

    public void er(int i) {
        this.asT = i;
    }
}
