package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String asK;
    private String asL;
    private String asM;
    private String asN;
    private String asQ;
    private String asR;
    private String asS;
    private String asT;
    private String asU;
    private String asV;
    private int aso = 0;
    private int asp = 0;
    private int asq = 0;
    private int asr = 0;
    private int ass = 0;
    private int ast = 0;
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
    private boolean asI = true;
    private boolean asJ = true;
    private HashMap<String, String> asO = new HashMap<>();
    private HashMap<String, String> asP = new HashMap<>();
    private String asW = null;
    private String asX = null;
    private List<b> asY = new ArrayList();
    private List<a> asZ = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int ata;
        public int atb;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ata;
        public int atb;
        public String atc;
        public String atd;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zC() {
        HashMap<String, String> zS = zS();
        Set<String> keySet = zS.keySet();
        if (keySet.size() != 1) {
            eJ(null);
        } else {
            eJ(zS.get(keySet.iterator().next()));
        }
    }

    public void zD() {
        HashMap<String, String> zY = zY();
        Set<String> keySet = zY.keySet();
        if (keySet.size() != 1) {
            eP(null);
        } else {
            eP(zY.get(keySet.iterator().next()));
        }
    }

    public int zE() {
        return this.aso;
    }

    public void dZ(int i) {
        this.aso = i;
    }

    public int zF() {
        return this.asr;
    }

    public void ea(int i) {
        this.asr = i;
    }

    public int zG() {
        return this.ass;
    }

    public int zH() {
        return this.asw;
    }

    public void eb(int i) {
        this.asw = i;
    }

    public int zI() {
        return this.asA;
    }

    public void ec(int i) {
        this.asA = i;
    }

    public int zJ() {
        return this.asz;
    }

    public void ed(int i) {
        this.asz = i;
    }

    public int zK() {
        return this.aso;
    }

    public int zL() {
        return this.asq;
    }

    public void ee(int i) {
        this.asq = i;
    }

    public boolean zM() {
        return this.asI;
    }

    public void bi(boolean z) {
        this.asI = z;
    }

    public String zN() {
        return this.asK;
    }

    public void eI(String str) {
        this.asK = str;
    }

    public String zO() {
        return this.asQ;
    }

    public void eJ(String str) {
        this.asQ = str;
    }

    public void eK(String str) {
        this.asR = str;
    }

    public int zP() {
        return this.asp;
    }

    public void ef(int i) {
        this.asp = i;
    }

    public void eL(String str) {
        this.asS = str;
    }

    public String zQ() {
        return this.asU;
    }

    public String zR() {
        return this.asV;
    }

    public HashMap<String, String> zS() {
        return this.asO;
    }

    public int zT() {
        return this.ast;
    }

    public void eg(int i) {
        this.ast = i;
    }

    public int zU() {
        return this.asx;
    }

    public void eh(int i) {
        this.asx = i;
    }

    public int zV() {
        return this.asB;
    }

    public void ei(int i) {
        this.asB = i;
    }

    public void eM(String str) {
        this.asL = str;
    }

    public void eN(String str) {
        this.asM = str;
    }

    public int zW() {
        return this.asy;
    }

    public void ej(int i) {
        this.asy = i;
    }

    public String zX() {
        return this.asN;
    }

    public void eO(String str) {
        this.asN = str;
    }

    public HashMap<String, String> zY() {
        return this.asP;
    }

    public String zZ() {
        return this.asT;
    }

    public void eP(String str) {
        this.asT = str;
    }

    public int Aa() {
        return this.asu;
    }

    public int Ab() {
        return this.asv;
    }

    public void ek(int i) {
        this.asu = i;
    }

    public void el(int i) {
        this.asv = i;
    }

    public void eQ(String str) {
        this.asW = str;
    }

    public void eR(String str) {
        this.asX = str;
    }

    public int Ac() {
        return this.asD;
    }

    public void em(int i) {
        this.asD = i;
    }

    public int Ad() {
        return this.asE;
    }

    public void en(int i) {
        this.asE = i;
    }

    public int Ae() {
        return this.asF;
    }

    public void eo(int i) {
        this.asF = i;
    }

    public int Af() {
        return this.asG;
    }

    public void ep(int i) {
        this.asG = i;
    }

    public List<b> Ag() {
        return this.asY;
    }

    public List<a> Ah() {
        return this.asZ;
    }

    public int Ai() {
        return this.asH;
    }

    public void eq(int i) {
        this.asH = i;
    }
}
