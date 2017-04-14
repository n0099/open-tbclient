package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ark;
    private String arl;
    private String arm;
    private String arn;
    private String arq;
    private String arr;
    private String ars;
    private String art;
    private String aru;
    private String arv;
    private int aqO = 0;
    private int aqP = 0;
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
    private boolean ari = true;
    private boolean arj = true;
    private HashMap<String, String> aro = new HashMap<>();
    private HashMap<String, String> arp = new HashMap<>();
    private String arw = null;
    private String arx = null;
    private List<b> ary = new ArrayList();
    private List<a> arz = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int arA;
        public int arB;
        public String content;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int arA;
        public int arB;
        public String arC;
        public String arD;
        public String content;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void Ao() {
        HashMap<String, String> AE = AE();
        Set<String> keySet = AE.keySet();
        if (keySet.size() != 1) {
            er(null);
        } else {
            er(AE.get(keySet.iterator().next()));
        }
    }

    public void Ap() {
        HashMap<String, String> AK = AK();
        Set<String> keySet = AK.keySet();
        if (keySet.size() != 1) {
            ex(null);
        } else {
            ex(AK.get(keySet.iterator().next()));
        }
    }

    public int Aq() {
        return this.aqO;
    }

    public void dK(int i) {
        this.aqO = i;
    }

    public int Ar() {
        return this.aqR;
    }

    public void dL(int i) {
        this.aqR = i;
    }

    public int As() {
        return this.aqS;
    }

    public int At() {
        return this.aqW;
    }

    public void dM(int i) {
        this.aqW = i;
    }

    public int Au() {
        return this.ara;
    }

    public void dN(int i) {
        this.ara = i;
    }

    public int Av() {
        return this.aqZ;
    }

    public void dO(int i) {
        this.aqZ = i;
    }

    public int Aw() {
        return this.aqO;
    }

    public int Ax() {
        return this.aqQ;
    }

    public void dP(int i) {
        this.aqQ = i;
    }

    public boolean Ay() {
        return this.ari;
    }

    public void bk(boolean z) {
        this.ari = z;
    }

    public String Az() {
        return this.ark;
    }

    public void eq(String str) {
        this.ark = str;
    }

    public String AA() {
        return this.arq;
    }

    public void er(String str) {
        this.arq = str;
    }

    public void es(String str) {
        this.arr = str;
    }

    public int AB() {
        return this.aqP;
    }

    public void dQ(int i) {
        this.aqP = i;
    }

    public void et(String str) {
        this.ars = str;
    }

    public String AC() {
        return this.aru;
    }

    public String AD() {
        return this.arv;
    }

    public HashMap<String, String> AE() {
        return this.aro;
    }

    public int AF() {
        return this.aqT;
    }

    public void dR(int i) {
        this.aqT = i;
    }

    public int AG() {
        return this.aqX;
    }

    public void dS(int i) {
        this.aqX = i;
    }

    public int AH() {
        return this.arb;
    }

    public void dT(int i) {
        this.arb = i;
    }

    public void eu(String str) {
        this.arl = str;
    }

    public void ev(String str) {
        this.arm = str;
    }

    public int AI() {
        return this.aqY;
    }

    public void dU(int i) {
        this.aqY = i;
    }

    public String AJ() {
        return this.arn;
    }

    public void ew(String str) {
        this.arn = str;
    }

    public HashMap<String, String> AK() {
        return this.arp;
    }

    public String AL() {
        return this.art;
    }

    public void ex(String str) {
        this.art = str;
    }

    public int AM() {
        return this.aqU;
    }

    public int AN() {
        return this.aqV;
    }

    public void dV(int i) {
        this.aqU = i;
    }

    public void dW(int i) {
        this.aqV = i;
    }

    public void ey(String str) {
        this.arw = str;
    }

    public void ez(String str) {
        this.arx = str;
    }

    public int AO() {
        return this.ard;
    }

    public void dX(int i) {
        this.ard = i;
    }

    public int AP() {
        return this.are;
    }

    public void dY(int i) {
        this.are = i;
    }

    public int AQ() {
        return this.arf;
    }

    public void dZ(int i) {
        this.arf = i;
    }

    public int AR() {
        return this.arg;
    }

    public void ea(int i) {
        this.arg = i;
    }

    public List<b> AS() {
        return this.ary;
    }

    public List<a> AT() {
        return this.arz;
    }

    public int AU() {
        return this.arh;
    }

    public void eb(int i) {
        this.arh = i;
    }
}
