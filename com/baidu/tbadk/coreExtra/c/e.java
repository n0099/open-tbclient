package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aqU;
    private String aqV;
    private String aqW;
    private String aqX;
    private String ara;
    private String arb;
    private String arc;
    private String ard;
    private String are;
    private String arf;
    private int aqy = 0;
    private int aqz = 0;
    private int aqA = 0;
    private int aqB = 0;
    private int aqC = 0;
    private int aqD = 0;
    private int aqE = 0;
    private int aqF = 0;
    private int aqG = 0;
    private int aqH = 0;
    private int aqI = 0;
    private int aqJ = 0;
    private int aqK = 0;
    private int aqL = 0;
    private int aqM = 0;
    private int aqN = 0;
    private int aqO = 0;
    private int aqP = 0;
    private int aqQ = 0;
    private int aqR = 0;
    private boolean aqS = true;
    private boolean aqT = true;
    private HashMap<String, String> aqY = new HashMap<>();
    private HashMap<String, String> aqZ = new HashMap<>();
    private String arg = null;
    private String arh = null;
    private List<b> ari = new ArrayList();
    private List<a> arj = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int ark;
        public int arl;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ark;
        public int arl;
        public String arm;
        public String arn;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zP() {
        HashMap<String, String> Af = Af();
        Set<String> keySet = Af.keySet();
        if (keySet.size() != 1) {
            el(null);
        } else {
            el(Af.get(keySet.iterator().next()));
        }
    }

    public void zQ() {
        HashMap<String, String> Al = Al();
        Set<String> keySet = Al.keySet();
        if (keySet.size() != 1) {
            er(null);
        } else {
            er(Al.get(keySet.iterator().next()));
        }
    }

    public int zR() {
        return this.aqy;
    }

    public void dH(int i) {
        this.aqy = i;
    }

    public int zS() {
        return this.aqB;
    }

    public void dI(int i) {
        this.aqB = i;
    }

    public int zT() {
        return this.aqC;
    }

    public int zU() {
        return this.aqG;
    }

    public void dJ(int i) {
        this.aqG = i;
    }

    public int zV() {
        return this.aqK;
    }

    public void dK(int i) {
        this.aqK = i;
    }

    public int zW() {
        return this.aqJ;
    }

    public void dL(int i) {
        this.aqJ = i;
    }

    public int zX() {
        return this.aqy;
    }

    public int zY() {
        return this.aqA;
    }

    public void dM(int i) {
        this.aqA = i;
    }

    public boolean zZ() {
        return this.aqS;
    }

    public void bi(boolean z) {
        this.aqS = z;
    }

    public String Aa() {
        return this.aqU;
    }

    public void ek(String str) {
        this.aqU = str;
    }

    public String Ab() {
        return this.ara;
    }

    public void el(String str) {
        this.ara = str;
    }

    public void em(String str) {
        this.arb = str;
    }

    public int Ac() {
        return this.aqz;
    }

    public void dN(int i) {
        this.aqz = i;
    }

    public void en(String str) {
        this.arc = str;
    }

    public String Ad() {
        return this.are;
    }

    public String Ae() {
        return this.arf;
    }

    public HashMap<String, String> Af() {
        return this.aqY;
    }

    public int Ag() {
        return this.aqD;
    }

    public void dO(int i) {
        this.aqD = i;
    }

    public int Ah() {
        return this.aqH;
    }

    public void dP(int i) {
        this.aqH = i;
    }

    public int Ai() {
        return this.aqL;
    }

    public void dQ(int i) {
        this.aqL = i;
    }

    public void eo(String str) {
        this.aqV = str;
    }

    public void ep(String str) {
        this.aqW = str;
    }

    public int Aj() {
        return this.aqI;
    }

    public void dR(int i) {
        this.aqI = i;
    }

    public String Ak() {
        return this.aqX;
    }

    public void eq(String str) {
        this.aqX = str;
    }

    public HashMap<String, String> Al() {
        return this.aqZ;
    }

    public String Am() {
        return this.ard;
    }

    public void er(String str) {
        this.ard = str;
    }

    public int An() {
        return this.aqE;
    }

    public int Ao() {
        return this.aqF;
    }

    public void dS(int i) {
        this.aqE = i;
    }

    public void dT(int i) {
        this.aqF = i;
    }

    public void es(String str) {
        this.arg = str;
    }

    public void et(String str) {
        this.arh = str;
    }

    public int Ap() {
        return this.aqN;
    }

    public void dU(int i) {
        this.aqN = i;
    }

    public int Aq() {
        return this.aqO;
    }

    public void dV(int i) {
        this.aqO = i;
    }

    public int Ar() {
        return this.aqP;
    }

    public void dW(int i) {
        this.aqP = i;
    }

    public int As() {
        return this.aqQ;
    }

    public void dX(int i) {
        this.aqQ = i;
    }

    public List<b> At() {
        return this.ari;
    }

    public List<a> Au() {
        return this.arj;
    }

    public int Av() {
        return this.aqR;
    }

    public void dY(int i) {
        this.aqR = i;
    }
}
