package com.baidu.tbadk.coreExtra.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ajR;
    private String ajS;
    private String ajT;
    private String ajU;
    private String ajX;
    private String ajY;
    private String ajZ;
    private String aka;
    private String akb;
    private String akc;
    private int ajv = 0;
    private int ajw = 0;
    private int ajx = 0;
    private int ajy = 0;
    private int ajz = 0;
    private int ajA = 0;
    private int ajB = 0;
    private int ajC = 0;
    private int ajD = 0;
    private int ajE = 0;
    private int ajF = 0;
    private int ajG = 0;
    private int ajH = 0;
    private int ajI = 0;
    private int ajJ = 0;
    private int ajK = 0;
    private int ajL = 0;
    private int ajM = 0;
    private int ajN = 0;
    private int ajO = 0;
    private boolean ajP = true;
    private boolean ajQ = true;
    private HashMap<String, String> ajV = new HashMap<>();
    private HashMap<String, String> ajW = new HashMap<>();
    private String akd = null;
    private String ake = null;
    private List<b> akf = new ArrayList();
    private List<a> akg = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public int akh;
        public String content;
        public int gid;
        public String groupName;
        public String title;
        public int unReadCount;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int akh;
        public String aki;
        public String akj;
        public String content;
        public int gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void yN() {
        HashMap<String, String> zd = zd();
        Set<String> keySet = zd.keySet();
        if (keySet.size() != 1) {
            em(null);
        } else {
            em(zd.get(keySet.iterator().next()));
        }
    }

    public void yO() {
        HashMap<String, String> zj = zj();
        Set<String> keySet = zj.keySet();
        if (keySet.size() != 1) {
            es(null);
        } else {
            es(zj.get(keySet.iterator().next()));
        }
    }

    public int yP() {
        return this.ajv;
    }

    public void du(int i) {
        this.ajv = i;
    }

    public int yQ() {
        return this.ajy;
    }

    public void dv(int i) {
        this.ajy = i;
    }

    public int yR() {
        return this.ajz;
    }

    public int yS() {
        return this.ajD;
    }

    public void dw(int i) {
        this.ajD = i;
    }

    public int yT() {
        return this.ajH;
    }

    public void dx(int i) {
        this.ajH = i;
    }

    public int yU() {
        return this.ajG;
    }

    public void dy(int i) {
        this.ajG = i;
    }

    public int yV() {
        return this.ajv;
    }

    public int yW() {
        return this.ajx;
    }

    public void dz(int i) {
        this.ajx = i;
    }

    public boolean yX() {
        return this.ajP;
    }

    public void aT(boolean z) {
        this.ajP = z;
    }

    public String yY() {
        return this.ajR;
    }

    public void el(String str) {
        this.ajR = str;
    }

    public String yZ() {
        return this.ajX;
    }

    public void em(String str) {
        this.ajX = str;
    }

    public void en(String str) {
        this.ajY = str;
    }

    public int za() {
        return this.ajw;
    }

    public void dA(int i) {
        this.ajw = i;
    }

    public void eo(String str) {
        this.ajZ = str;
    }

    public String zb() {
        return this.akb;
    }

    public String zc() {
        return this.akc;
    }

    public HashMap<String, String> zd() {
        return this.ajV;
    }

    public int ze() {
        return this.ajA;
    }

    public void dB(int i) {
        this.ajA = i;
    }

    public int zf() {
        return this.ajE;
    }

    public void dC(int i) {
        this.ajE = i;
    }

    public int zg() {
        return this.ajI;
    }

    public void dD(int i) {
        this.ajI = i;
    }

    public void ep(String str) {
        this.ajS = str;
    }

    public void eq(String str) {
        this.ajT = str;
    }

    public int zh() {
        return this.ajF;
    }

    public void dE(int i) {
        this.ajF = i;
    }

    public String zi() {
        return this.ajU;
    }

    public void er(String str) {
        this.ajU = str;
    }

    public HashMap<String, String> zj() {
        return this.ajW;
    }

    public String zk() {
        return this.aka;
    }

    public void es(String str) {
        this.aka = str;
    }

    public int zl() {
        return this.ajB;
    }

    public int zm() {
        return this.ajC;
    }

    public void dF(int i) {
        this.ajB = i;
    }

    public void dG(int i) {
        this.ajC = i;
    }

    public void et(String str) {
        this.akd = str;
    }

    public void eu(String str) {
        this.ake = str;
    }

    public int zn() {
        return this.ajK;
    }

    public void dH(int i) {
        this.ajK = i;
    }

    public int zo() {
        return this.ajL;
    }

    public void dI(int i) {
        this.ajL = i;
    }

    public int zp() {
        return this.ajM;
    }

    public void dJ(int i) {
        this.ajM = i;
    }

    public int zq() {
        return this.ajN;
    }

    public void dK(int i) {
        this.ajN = i;
    }

    public List<b> zr() {
        return this.akf;
    }

    public List<a> zs() {
        return this.akg;
    }

    public int zt() {
        return this.ajO;
    }

    public void dL(int i) {
        this.ajO = i;
    }
}
