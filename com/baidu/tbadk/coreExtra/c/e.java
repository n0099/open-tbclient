package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String atO;
    private String atP;
    private String atQ;
    private String atR;
    private String atU;
    private String atV;
    private String atW;
    private String atX;
    private String atY;
    private String atZ;
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
    private int atK = 0;
    private int atL = 0;
    private boolean atM = true;
    private boolean atN = true;
    private HashMap<String, String> atS = new HashMap<>();
    private HashMap<String, String> atT = new HashMap<>();
    private String aua = null;
    private String aub = null;
    private List<b> auc = new ArrayList();
    private List<a> aud = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int aue;
        public int auf;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int aue;
        public int auf;
        public String aug;
        public String auh;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Ak() {
        HashMap<String, String> AA = AA();
        Set<String> keySet = AA.keySet();
        if (keySet.size() != 1) {
            eR(null);
        } else {
            eR(AA.get(keySet.iterator().next()));
        }
    }

    public void Al() {
        HashMap<String, String> AG = AG();
        Set<String> keySet = AG.keySet();
        if (keySet.size() != 1) {
            eX(null);
        } else {
            eX(AG.get(keySet.iterator().next()));
        }
    }

    public int Am() {
        return this.ats;
    }

    public void dQ(int i) {
        this.ats = i;
    }

    public int An() {
        return this.atv;
    }

    public void dR(int i) {
        this.atv = i;
    }

    public int Ao() {
        return this.atw;
    }

    public int Ap() {
        return this.atA;
    }

    public void dS(int i) {
        this.atA = i;
    }

    public int Aq() {
        return this.atE;
    }

    public void dT(int i) {
        this.atE = i;
    }

    public int Ar() {
        return this.atD;
    }

    public void dU(int i) {
        this.atD = i;
    }

    public int As() {
        return this.ats;
    }

    public int At() {
        return this.atu;
    }

    public void dV(int i) {
        this.atu = i;
    }

    public boolean Au() {
        return this.atM;
    }

    public void bk(boolean z) {
        this.atM = z;
    }

    public String Av() {
        return this.atO;
    }

    public void eQ(String str) {
        this.atO = str;
    }

    public String Aw() {
        return this.atU;
    }

    public void eR(String str) {
        this.atU = str;
    }

    public void eS(String str) {
        this.atV = str;
    }

    public int Ax() {
        return this.att;
    }

    public void dW(int i) {
        this.att = i;
    }

    public void eT(String str) {
        this.atW = str;
    }

    public String Ay() {
        return this.atY;
    }

    public String Az() {
        return this.atZ;
    }

    public HashMap<String, String> AA() {
        return this.atS;
    }

    public int AB() {
        return this.atx;
    }

    public void dX(int i) {
        this.atx = i;
    }

    public int AC() {
        return this.atB;
    }

    public void dY(int i) {
        this.atB = i;
    }

    public int AD() {
        return this.atF;
    }

    public void dZ(int i) {
        this.atF = i;
    }

    public void eU(String str) {
        this.atP = str;
    }

    public void eV(String str) {
        this.atQ = str;
    }

    public int AE() {
        return this.atC;
    }

    public void ea(int i) {
        this.atC = i;
    }

    public String AF() {
        return this.atR;
    }

    public void eW(String str) {
        this.atR = str;
    }

    public HashMap<String, String> AG() {
        return this.atT;
    }

    public String AH() {
        return this.atX;
    }

    public void eX(String str) {
        this.atX = str;
    }

    public int AI() {
        return this.aty;
    }

    public int AJ() {
        return this.atz;
    }

    public void eb(int i) {
        this.aty = i;
    }

    public void ec(int i) {
        this.atz = i;
    }

    public void eY(String str) {
        this.aua = str;
    }

    public void eZ(String str) {
        this.aub = str;
    }

    public int AK() {
        return this.atH;
    }

    public void ed(int i) {
        this.atH = i;
    }

    public int AL() {
        return this.atI;
    }

    public void ee(int i) {
        this.atI = i;
    }

    public int AM() {
        return this.atJ;
    }

    public void ef(int i) {
        this.atJ = i;
    }

    public int AN() {
        return this.atK;
    }

    public void eg(int i) {
        this.atK = i;
    }

    public List<b> AO() {
        return this.auc;
    }

    public List<a> AP() {
        return this.aud;
    }

    public int AQ() {
        return this.atL;
    }

    public void eh(int i) {
        this.atL = i;
    }
}
