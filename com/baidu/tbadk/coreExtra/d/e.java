package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String amS;
    private String amT;
    private String amU;
    private String amV;
    private String amY;
    private String amZ;
    private String ana;
    private String anb;
    private String anc;
    private String and;
    private int amw = 0;
    private int amx = 0;
    private int amy = 0;
    private int amz = 0;
    private int amA = 0;
    private int amB = 0;
    private int amC = 0;
    private int amD = 0;
    private int amE = 0;
    private int amF = 0;
    private int amG = 0;
    private int amH = 0;
    private int amI = 0;
    private int amJ = 0;
    private int amK = 0;
    private int amL = 0;
    private int amM = 0;
    private int amN = 0;
    private int amO = 0;
    private int amP = 0;
    private boolean amQ = true;
    private boolean amR = true;
    private HashMap<String, String> amW = new HashMap<>();
    private HashMap<String, String> amX = new HashMap<>();
    private String ane = null;
    private String anf = null;
    private List<b> ang = new ArrayList();
    private List<a> anh = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int ani;
        public int anj;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int ani;
        public int anj;
        public String ank;
        public String anl;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zQ() {
        HashMap<String, String> Ag = Ag();
        Set<String> keySet = Ag.keySet();
        if (keySet.size() != 1) {
            eC(null);
        } else {
            eC(Ag.get(keySet.iterator().next()));
        }
    }

    public void zR() {
        HashMap<String, String> Am = Am();
        Set<String> keySet = Am.keySet();
        if (keySet.size() != 1) {
            eI(null);
        } else {
            eI(Am.get(keySet.iterator().next()));
        }
    }

    public int zS() {
        return this.amw;
    }

    public void dJ(int i) {
        this.amw = i;
    }

    public int zT() {
        return this.amz;
    }

    public void dK(int i) {
        this.amz = i;
    }

    public int zU() {
        return this.amA;
    }

    public int zV() {
        return this.amE;
    }

    public void dL(int i) {
        this.amE = i;
    }

    public int zW() {
        return this.amI;
    }

    public void dM(int i) {
        this.amI = i;
    }

    public int zX() {
        return this.amH;
    }

    public void dN(int i) {
        this.amH = i;
    }

    public int zY() {
        return this.amw;
    }

    public int zZ() {
        return this.amy;
    }

    public void dO(int i) {
        this.amy = i;
    }

    public boolean Aa() {
        return this.amQ;
    }

    public void bj(boolean z) {
        this.amQ = z;
    }

    public String Ab() {
        return this.amS;
    }

    public void eB(String str) {
        this.amS = str;
    }

    public String Ac() {
        return this.amY;
    }

    public void eC(String str) {
        this.amY = str;
    }

    public void eD(String str) {
        this.amZ = str;
    }

    public int Ad() {
        return this.amx;
    }

    public void dP(int i) {
        this.amx = i;
    }

    public void eE(String str) {
        this.ana = str;
    }

    public String Ae() {
        return this.anc;
    }

    public String Af() {
        return this.and;
    }

    public HashMap<String, String> Ag() {
        return this.amW;
    }

    public int Ah() {
        return this.amB;
    }

    public void dQ(int i) {
        this.amB = i;
    }

    public int Ai() {
        return this.amF;
    }

    public void dR(int i) {
        this.amF = i;
    }

    public int Aj() {
        return this.amJ;
    }

    public void dS(int i) {
        this.amJ = i;
    }

    public void eF(String str) {
        this.amT = str;
    }

    public void eG(String str) {
        this.amU = str;
    }

    public int Ak() {
        return this.amG;
    }

    public void dT(int i) {
        this.amG = i;
    }

    public String Al() {
        return this.amV;
    }

    public void eH(String str) {
        this.amV = str;
    }

    public HashMap<String, String> Am() {
        return this.amX;
    }

    public String An() {
        return this.anb;
    }

    public void eI(String str) {
        this.anb = str;
    }

    public int Ao() {
        return this.amC;
    }

    public int Ap() {
        return this.amD;
    }

    public void dU(int i) {
        this.amC = i;
    }

    public void dV(int i) {
        this.amD = i;
    }

    public void eJ(String str) {
        this.ane = str;
    }

    public void eK(String str) {
        this.anf = str;
    }

    public int Aq() {
        return this.amL;
    }

    public void dW(int i) {
        this.amL = i;
    }

    public int Ar() {
        return this.amM;
    }

    public void dX(int i) {
        this.amM = i;
    }

    public int As() {
        return this.amN;
    }

    public void dY(int i) {
        this.amN = i;
    }

    public int At() {
        return this.amO;
    }

    public void dZ(int i) {
        this.amO = i;
    }

    public List<b> Au() {
        return this.ang;
    }

    public List<a> Av() {
        return this.anh;
    }

    public int Aw() {
        return this.amP;
    }

    public void ea(int i) {
        this.amP = i;
    }
}
