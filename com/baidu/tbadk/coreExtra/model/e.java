package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String atJ;
    private String atK;
    private String atL;
    private String atM;
    private String atP;
    private String atQ;
    private String atR;
    private String atS;
    private String atT;
    private String atU;
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
    private int atC = 0;
    private int atD = 0;
    private int atE = 0;
    private int atF = 0;
    private int atG = 0;
    private boolean atH = true;
    private boolean atI = true;
    private HashMap<String, String> atN = new HashMap<>();
    private HashMap<String, String> atO = new HashMap<>();
    private String atV = null;
    private String atW = null;
    private List<b> atX = new ArrayList();
    private List<a> atY = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int atZ;
        public int aua;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int atZ;
        public int aua;
        public String aub;
        public String auc;
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
        return this.atn;
    }

    public void ea(int i) {
        this.atn = i;
    }

    public int zZ() {
        return this.atq;
    }

    public void eb(int i) {
        this.atq = i;
    }

    public int Aa() {
        return this.atr;
    }

    public int Ab() {
        return this.atv;
    }

    public void ec(int i) {
        this.atv = i;
    }

    public int Ac() {
        return this.atz;
    }

    public void ed(int i) {
        this.atz = i;
    }

    public int Ad() {
        return this.aty;
    }

    public void ee(int i) {
        this.aty = i;
    }

    public int Ae() {
        return this.atn;
    }

    public int Af() {
        return this.atp;
    }

    public void ef(int i) {
        this.atp = i;
    }

    public boolean Ag() {
        return this.atH;
    }

    public void bi(boolean z) {
        this.atH = z;
    }

    public String Ah() {
        return this.atJ;
    }

    public void eT(String str) {
        this.atJ = str;
    }

    public String Ai() {
        return this.atP;
    }

    public void eU(String str) {
        this.atP = str;
    }

    public void eV(String str) {
        this.atQ = str;
    }

    public int Aj() {
        return this.ato;
    }

    public void eg(int i) {
        this.ato = i;
    }

    public void eW(String str) {
        this.atR = str;
    }

    public String Ak() {
        return this.atT;
    }

    public String Al() {
        return this.atU;
    }

    public HashMap<String, String> Am() {
        return this.atN;
    }

    public int An() {
        return this.ats;
    }

    public void eh(int i) {
        this.ats = i;
    }

    public int Ao() {
        return this.atw;
    }

    public void ei(int i) {
        this.atw = i;
    }

    public int Ap() {
        return this.atA;
    }

    public void ej(int i) {
        this.atA = i;
    }

    public void eX(String str) {
        this.atK = str;
    }

    public void eY(String str) {
        this.atL = str;
    }

    public int Aq() {
        return this.atx;
    }

    public void ek(int i) {
        this.atx = i;
    }

    public String Ar() {
        return this.atM;
    }

    public void eZ(String str) {
        this.atM = str;
    }

    public HashMap<String, String> As() {
        return this.atO;
    }

    public String At() {
        return this.atS;
    }

    public void fa(String str) {
        this.atS = str;
    }

    public int Au() {
        return this.att;
    }

    public int Av() {
        return this.atu;
    }

    public void el(int i) {
        this.att = i;
    }

    public void em(int i) {
        this.atu = i;
    }

    public void fb(String str) {
        this.atV = str;
    }

    public void fc(String str) {
        this.atW = str;
    }

    public int Aw() {
        return this.atC;
    }

    public void en(int i) {
        this.atC = i;
    }

    public int Ax() {
        return this.atD;
    }

    public void eo(int i) {
        this.atD = i;
    }

    public int Ay() {
        return this.atE;
    }

    public void ep(int i) {
        this.atE = i;
    }

    public int Az() {
        return this.atF;
    }

    public void eq(int i) {
        this.atF = i;
    }

    public List<b> AA() {
        return this.atX;
    }

    public List<a> AB() {
        return this.atY;
    }

    public int AC() {
        return this.atG;
    }

    public void er(int i) {
        this.atG = i;
    }
}
