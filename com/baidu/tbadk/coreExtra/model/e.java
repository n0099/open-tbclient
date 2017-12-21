package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String atM;
    private String atN;
    private String atO;
    private String atP;
    private String atS;
    private String atT;
    private String atU;
    private String atV;
    private String atW;
    private String atX;
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
    private int atC = 0;
    private int atD = 0;
    private int atE = 0;
    private int atF = 0;
    private int atG = 0;
    private int atH = 0;
    private int atI = 0;
    private int atJ = 0;
    private boolean atK = true;
    private boolean atL = true;
    private HashMap<String, String> atQ = new HashMap<>();
    private HashMap<String, String> atR = new HashMap<>();
    private String atY = null;
    private String atZ = null;
    private List<b> aua = new ArrayList();
    private List<a> aub = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int auc;
        public int aud;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int auc;
        public int aud;
        public String aue;
        public String auf;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zW() {
        HashMap<String, String> Am = Am();
        Set<String> keySet = Am.keySet();
        if (keySet.size() != 1) {
            eU(null);
        } else {
            eU(Am.get(keySet.iterator().next()));
        }
    }

    public void zX() {
        HashMap<String, String> As = As();
        Set<String> keySet = As.keySet();
        if (keySet.size() != 1) {
            fa(null);
        } else {
            fa(As.get(keySet.iterator().next()));
        }
    }

    public int zY() {
        return this.atq;
    }

    public void ea(int i) {
        this.atq = i;
    }

    public int zZ() {
        return this.att;
    }

    public void eb(int i) {
        this.att = i;
    }

    public int Aa() {
        return this.atu;
    }

    public int Ab() {
        return this.aty;
    }

    public void ec(int i) {
        this.aty = i;
    }

    public int Ac() {
        return this.atC;
    }

    public void ed(int i) {
        this.atC = i;
    }

    public int Ad() {
        return this.atB;
    }

    public void ee(int i) {
        this.atB = i;
    }

    public int Ae() {
        return this.atq;
    }

    public int Af() {
        return this.ats;
    }

    public void ef(int i) {
        this.ats = i;
    }

    public boolean Ag() {
        return this.atK;
    }

    public void bi(boolean z) {
        this.atK = z;
    }

    public String Ah() {
        return this.atM;
    }

    public void eT(String str) {
        this.atM = str;
    }

    public String Ai() {
        return this.atS;
    }

    public void eU(String str) {
        this.atS = str;
    }

    public void eV(String str) {
        this.atT = str;
    }

    public int Aj() {
        return this.atr;
    }

    public void eg(int i) {
        this.atr = i;
    }

    public void eW(String str) {
        this.atU = str;
    }

    public String Ak() {
        return this.atW;
    }

    public String Al() {
        return this.atX;
    }

    public HashMap<String, String> Am() {
        return this.atQ;
    }

    public int An() {
        return this.atv;
    }

    public void eh(int i) {
        this.atv = i;
    }

    public int Ao() {
        return this.atz;
    }

    public void ei(int i) {
        this.atz = i;
    }

    public int Ap() {
        return this.atD;
    }

    public void ej(int i) {
        this.atD = i;
    }

    public void eX(String str) {
        this.atN = str;
    }

    public void eY(String str) {
        this.atO = str;
    }

    public int Aq() {
        return this.atA;
    }

    public void ek(int i) {
        this.atA = i;
    }

    public String Ar() {
        return this.atP;
    }

    public void eZ(String str) {
        this.atP = str;
    }

    public HashMap<String, String> As() {
        return this.atR;
    }

    public String At() {
        return this.atV;
    }

    public void fa(String str) {
        this.atV = str;
    }

    public int Au() {
        return this.atw;
    }

    public int Av() {
        return this.atx;
    }

    public void el(int i) {
        this.atw = i;
    }

    public void em(int i) {
        this.atx = i;
    }

    public void fb(String str) {
        this.atY = str;
    }

    public void fc(String str) {
        this.atZ = str;
    }

    public int Aw() {
        return this.atF;
    }

    public void en(int i) {
        this.atF = i;
    }

    public int Ax() {
        return this.atG;
    }

    public void eo(int i) {
        this.atG = i;
    }

    public int Ay() {
        return this.atH;
    }

    public void ep(int i) {
        this.atH = i;
    }

    public int Az() {
        return this.atI;
    }

    public void eq(int i) {
        this.atI = i;
    }

    public List<b> AA() {
        return this.aua;
    }

    public List<a> AB() {
        return this.aub;
    }

    public int AC() {
        return this.atJ;
    }

    public void er(int i) {
        this.atJ = i;
    }
}
