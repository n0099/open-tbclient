package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String atR;
    private String atS;
    private String atT;
    private String atU;
    private String atX;
    private String atY;
    private String atZ;
    private String aua;
    private String aub;
    private String auc;
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
    private int atM = 0;
    private int atN = 0;
    private int atO = 0;
    private boolean atP = true;
    private boolean atQ = true;
    private HashMap<String, String> atV = new HashMap<>();
    private HashMap<String, String> atW = new HashMap<>();
    private String aud = null;
    private String aue = null;
    private List<b> auf = new ArrayList();
    private List<a> aug = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int auh;
        public int aui;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int auh;
        public int aui;
        public String auj;
        public String auk;
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
        return this.atv;
    }

    public void dQ(int i) {
        this.atv = i;
    }

    public int An() {
        return this.aty;
    }

    public void dR(int i) {
        this.aty = i;
    }

    public int Ao() {
        return this.atz;
    }

    public int Ap() {
        return this.atD;
    }

    public void dS(int i) {
        this.atD = i;
    }

    public int Aq() {
        return this.atH;
    }

    public void dT(int i) {
        this.atH = i;
    }

    public int Ar() {
        return this.atG;
    }

    public void dU(int i) {
        this.atG = i;
    }

    public int As() {
        return this.atv;
    }

    public int At() {
        return this.atx;
    }

    public void dV(int i) {
        this.atx = i;
    }

    public boolean Au() {
        return this.atP;
    }

    public void bk(boolean z) {
        this.atP = z;
    }

    public String Av() {
        return this.atR;
    }

    public void eQ(String str) {
        this.atR = str;
    }

    public String Aw() {
        return this.atX;
    }

    public void eR(String str) {
        this.atX = str;
    }

    public void eS(String str) {
        this.atY = str;
    }

    public int Ax() {
        return this.atw;
    }

    public void dW(int i) {
        this.atw = i;
    }

    public void eT(String str) {
        this.atZ = str;
    }

    public String Ay() {
        return this.aub;
    }

    public String Az() {
        return this.auc;
    }

    public HashMap<String, String> AA() {
        return this.atV;
    }

    public int AB() {
        return this.atA;
    }

    public void dX(int i) {
        this.atA = i;
    }

    public int AC() {
        return this.atE;
    }

    public void dY(int i) {
        this.atE = i;
    }

    public int AD() {
        return this.atI;
    }

    public void dZ(int i) {
        this.atI = i;
    }

    public void eU(String str) {
        this.atS = str;
    }

    public void eV(String str) {
        this.atT = str;
    }

    public int AE() {
        return this.atF;
    }

    public void ea(int i) {
        this.atF = i;
    }

    public String AF() {
        return this.atU;
    }

    public void eW(String str) {
        this.atU = str;
    }

    public HashMap<String, String> AG() {
        return this.atW;
    }

    public String AH() {
        return this.aua;
    }

    public void eX(String str) {
        this.aua = str;
    }

    public int AI() {
        return this.atB;
    }

    public int AJ() {
        return this.atC;
    }

    public void eb(int i) {
        this.atB = i;
    }

    public void ec(int i) {
        this.atC = i;
    }

    public void eY(String str) {
        this.aud = str;
    }

    public void eZ(String str) {
        this.aue = str;
    }

    public int AK() {
        return this.atK;
    }

    public void ed(int i) {
        this.atK = i;
    }

    public int AL() {
        return this.atL;
    }

    public void ee(int i) {
        this.atL = i;
    }

    public int AM() {
        return this.atM;
    }

    public void ef(int i) {
        this.atM = i;
    }

    public int AN() {
        return this.atN;
    }

    public void eg(int i) {
        this.atN = i;
    }

    public List<b> AO() {
        return this.auf;
    }

    public List<a> AP() {
        return this.aug;
    }

    public int AQ() {
        return this.atO;
    }

    public void eh(int i) {
        this.atO = i;
    }
}
