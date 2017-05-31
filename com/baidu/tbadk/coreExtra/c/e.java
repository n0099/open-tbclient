package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aqW;
    private String aqX;
    private String aqY;
    private String aqZ;
    private String arc;
    private String ard;
    private String are;
    private String arf;
    private String arg;
    private String arh;
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
    private int aqS = 0;
    private int aqT = 0;
    private boolean aqU = true;
    private boolean aqV = true;
    private HashMap<String, String> ara = new HashMap<>();
    private HashMap<String, String> arb = new HashMap<>();
    private String ari = null;
    private String arj = null;
    private List<b> ark = new ArrayList();
    private List<a> arl = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int arm;
        public int arn;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int arm;
        public int arn;
        public String aro;
        public String arp;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zs() {
        HashMap<String, String> zI = zI();
        Set<String> keySet = zI.keySet();
        if (keySet.size() != 1) {
            eo(null);
        } else {
            eo(zI.get(keySet.iterator().next()));
        }
    }

    public void zt() {
        HashMap<String, String> zO = zO();
        Set<String> keySet = zO.keySet();
        if (keySet.size() != 1) {
            eu(null);
        } else {
            eu(zO.get(keySet.iterator().next()));
        }
    }

    public int zu() {
        return this.aqA;
    }

    public void dJ(int i) {
        this.aqA = i;
    }

    public int zv() {
        return this.aqD;
    }

    public void dK(int i) {
        this.aqD = i;
    }

    public int zw() {
        return this.aqE;
    }

    public int zx() {
        return this.aqI;
    }

    public void dL(int i) {
        this.aqI = i;
    }

    public int zy() {
        return this.aqM;
    }

    public void dM(int i) {
        this.aqM = i;
    }

    public int zz() {
        return this.aqL;
    }

    public void dN(int i) {
        this.aqL = i;
    }

    public int zA() {
        return this.aqA;
    }

    public int zB() {
        return this.aqC;
    }

    public void dO(int i) {
        this.aqC = i;
    }

    public boolean zC() {
        return this.aqU;
    }

    public void bh(boolean z) {
        this.aqU = z;
    }

    public String zD() {
        return this.aqW;
    }

    public void en(String str) {
        this.aqW = str;
    }

    public String zE() {
        return this.arc;
    }

    public void eo(String str) {
        this.arc = str;
    }

    public void ep(String str) {
        this.ard = str;
    }

    public int zF() {
        return this.aqB;
    }

    public void dP(int i) {
        this.aqB = i;
    }

    public void eq(String str) {
        this.are = str;
    }

    public String zG() {
        return this.arg;
    }

    public String zH() {
        return this.arh;
    }

    public HashMap<String, String> zI() {
        return this.ara;
    }

    public int zJ() {
        return this.aqF;
    }

    public void dQ(int i) {
        this.aqF = i;
    }

    public int zK() {
        return this.aqJ;
    }

    public void dR(int i) {
        this.aqJ = i;
    }

    public int zL() {
        return this.aqN;
    }

    public void dS(int i) {
        this.aqN = i;
    }

    public void er(String str) {
        this.aqX = str;
    }

    public void es(String str) {
        this.aqY = str;
    }

    public int zM() {
        return this.aqK;
    }

    public void dT(int i) {
        this.aqK = i;
    }

    public String zN() {
        return this.aqZ;
    }

    public void et(String str) {
        this.aqZ = str;
    }

    public HashMap<String, String> zO() {
        return this.arb;
    }

    public String zP() {
        return this.arf;
    }

    public void eu(String str) {
        this.arf = str;
    }

    public int zQ() {
        return this.aqG;
    }

    public int zR() {
        return this.aqH;
    }

    public void dU(int i) {
        this.aqG = i;
    }

    public void dV(int i) {
        this.aqH = i;
    }

    public void ev(String str) {
        this.ari = str;
    }

    public void ew(String str) {
        this.arj = str;
    }

    public int zS() {
        return this.aqP;
    }

    public void dW(int i) {
        this.aqP = i;
    }

    public int zT() {
        return this.aqQ;
    }

    public void dX(int i) {
        this.aqQ = i;
    }

    public int zU() {
        return this.aqR;
    }

    public void dY(int i) {
        this.aqR = i;
    }

    public int zV() {
        return this.aqS;
    }

    public void dZ(int i) {
        this.aqS = i;
    }

    public List<b> zW() {
        return this.ark;
    }

    public List<a> zX() {
        return this.arl;
    }

    public int zY() {
        return this.aqT;
    }

    public void ea(int i) {
        this.aqT = i;
    }
}
