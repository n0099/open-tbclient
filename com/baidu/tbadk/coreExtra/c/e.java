package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String arm;
    private String arn;
    private String aro;
    private String arp;
    private String ars;
    private String art;
    private String aru;
    private String arv;
    private String arw;
    private String arx;
    private int aqQ = 0;
    private int aqR = 0;
    private int aqS = 0;
    private int aqT = 0;
    private int aqU = 0;
    private int aqV = 0;
    private int aqW = 0;
    private int aqX = 0;
    private int aqY = 0;
    private int aqZ = 0;
    private int ara = 0;
    private int arb = 0;
    private int arc = 0;
    private int ard = 0;
    private int are = 0;
    private int arf = 0;
    private int arg = 0;
    private int arh = 0;
    private int ari = 0;
    private int arj = 0;
    private boolean ark = true;
    private boolean arl = true;
    private HashMap<String, String> arq = new HashMap<>();
    private HashMap<String, String> arr = new HashMap<>();
    private String ary = null;
    private String arz = null;
    private List<b> arA = new ArrayList();
    private List<a> arB = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int arC;
        public int arD;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int arC;
        public int arD;
        public String arE;
        public String arF;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void zz() {
        HashMap<String, String> zP = zP();
        Set<String> keySet = zP.keySet();
        if (keySet.size() != 1) {
            eq(null);
        } else {
            eq(zP.get(keySet.iterator().next()));
        }
    }

    public void zA() {
        HashMap<String, String> zV = zV();
        Set<String> keySet = zV.keySet();
        if (keySet.size() != 1) {
            ew(null);
        } else {
            ew(zV.get(keySet.iterator().next()));
        }
    }

    public int zB() {
        return this.aqQ;
    }

    public void dI(int i) {
        this.aqQ = i;
    }

    public int zC() {
        return this.aqT;
    }

    public void dJ(int i) {
        this.aqT = i;
    }

    public int zD() {
        return this.aqU;
    }

    public int zE() {
        return this.aqY;
    }

    public void dK(int i) {
        this.aqY = i;
    }

    public int zF() {
        return this.arc;
    }

    public void dL(int i) {
        this.arc = i;
    }

    public int zG() {
        return this.arb;
    }

    public void dM(int i) {
        this.arb = i;
    }

    public int zH() {
        return this.aqQ;
    }

    public int zI() {
        return this.aqS;
    }

    public void dN(int i) {
        this.aqS = i;
    }

    public boolean zJ() {
        return this.ark;
    }

    public void bk(boolean z) {
        this.ark = z;
    }

    public String zK() {
        return this.arm;
    }

    public void ep(String str) {
        this.arm = str;
    }

    public String zL() {
        return this.ars;
    }

    public void eq(String str) {
        this.ars = str;
    }

    public void er(String str) {
        this.art = str;
    }

    public int zM() {
        return this.aqR;
    }

    public void dO(int i) {
        this.aqR = i;
    }

    public void es(String str) {
        this.aru = str;
    }

    public String zN() {
        return this.arw;
    }

    public String zO() {
        return this.arx;
    }

    public HashMap<String, String> zP() {
        return this.arq;
    }

    public int zQ() {
        return this.aqV;
    }

    public void dP(int i) {
        this.aqV = i;
    }

    public int zR() {
        return this.aqZ;
    }

    public void dQ(int i) {
        this.aqZ = i;
    }

    public int zS() {
        return this.ard;
    }

    public void dR(int i) {
        this.ard = i;
    }

    public void et(String str) {
        this.arn = str;
    }

    public void eu(String str) {
        this.aro = str;
    }

    public int zT() {
        return this.ara;
    }

    public void dS(int i) {
        this.ara = i;
    }

    public String zU() {
        return this.arp;
    }

    public void ev(String str) {
        this.arp = str;
    }

    public HashMap<String, String> zV() {
        return this.arr;
    }

    public String zW() {
        return this.arv;
    }

    public void ew(String str) {
        this.arv = str;
    }

    public int zX() {
        return this.aqW;
    }

    public int zY() {
        return this.aqX;
    }

    public void dT(int i) {
        this.aqW = i;
    }

    public void dU(int i) {
        this.aqX = i;
    }

    public void ex(String str) {
        this.ary = str;
    }

    public void ey(String str) {
        this.arz = str;
    }

    public int zZ() {
        return this.arf;
    }

    public void dV(int i) {
        this.arf = i;
    }

    public int Aa() {
        return this.arg;
    }

    public void dW(int i) {
        this.arg = i;
    }

    public int Ab() {
        return this.arh;
    }

    public void dX(int i) {
        this.arh = i;
    }

    public int Ac() {
        return this.ari;
    }

    public void dY(int i) {
        this.ari = i;
    }

    public List<b> Ad() {
        return this.arA;
    }

    public List<a> Ae() {
        return this.arB;
    }

    public int Af() {
        return this.arj;
    }

    public void dZ(int i) {
        this.arj = i;
    }
}
