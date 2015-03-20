package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class h {
    private String acA;
    private String acB;
    private String acC;
    private String acD;
    private String acE;
    private String acF;
    private String acu;
    private String acv;
    private String acw;
    private String acx;
    private int abZ = 0;
    private int aca = 0;
    private int acb = 0;
    private int acc = 0;
    private int acd = 0;
    private int ace = 0;
    private int acf = 0;
    private int acg = 0;
    private int ach = 0;
    private int aci = 0;
    private int acj = 0;
    private int ack = 0;
    private int acl = 0;
    private int acm = 0;
    private int acn = 0;
    private int aco = 0;
    private int acp = 0;
    private int acq = 0;
    private boolean acr = true;
    private boolean acs = true;
    private HashMap<String, String> acy = new HashMap<>();
    private HashMap<String, String> acz = new HashMap<>();
    private String acG = null;
    private String acH = null;
    private List<i> acI = new ArrayList();

    public void vY() {
        HashMap<String, String> wo = wo();
        Set<String> keySet = wo.keySet();
        if (keySet.size() != 1) {
            dw(null);
        } else {
            dw(wo.get(keySet.iterator().next()));
        }
    }

    public void vZ() {
        HashMap<String, String> wu = wu();
        Set<String> keySet = wu.keySet();
        if (keySet.size() != 1) {
            dC(null);
        } else {
            dC(wu.get(keySet.iterator().next()));
        }
    }

    public int wa() {
        return this.abZ;
    }

    public void cG(int i) {
        this.abZ = i;
    }

    public int wb() {
        return this.acc;
    }

    public void cH(int i) {
        this.acc = i;
    }

    public int wc() {
        return this.acd;
    }

    public int wd() {
        return this.ach;
    }

    public void cI(int i) {
        this.ach = i;
    }

    public int we() {
        return this.acl;
    }

    public void cJ(int i) {
        this.acl = i;
    }

    public int wf() {
        return this.ack;
    }

    public void cK(int i) {
        this.ack = i;
    }

    public int wg() {
        return this.abZ;
    }

    public int wh() {
        return this.acb;
    }

    public void cL(int i) {
        this.acb = i;
    }

    public boolean wi() {
        return this.acr;
    }

    public void aD(boolean z) {
        this.acr = z;
    }

    public String wj() {
        return this.acu;
    }

    public void dv(String str) {
        this.acu = str;
    }

    public String wk() {
        return this.acA;
    }

    public void dw(String str) {
        this.acA = str;
    }

    public void dx(String str) {
        this.acB = str;
    }

    public int wl() {
        return this.aca;
    }

    public void cM(int i) {
        this.aca = i;
    }

    public void dy(String str) {
        this.acC = str;
    }

    public String wm() {
        return this.acE;
    }

    public String wn() {
        return this.acF;
    }

    public HashMap<String, String> wo() {
        return this.acy;
    }

    public int wp() {
        return this.ace;
    }

    public void cN(int i) {
        this.ace = i;
    }

    public int wq() {
        return this.aci;
    }

    public void cO(int i) {
        this.aci = i;
    }

    public int wr() {
        return this.acm;
    }

    public void cP(int i) {
        this.acm = i;
    }

    public void dz(String str) {
        this.acv = str;
    }

    public void dA(String str) {
        this.acw = str;
    }

    public int ws() {
        return this.acj;
    }

    public void cQ(int i) {
        this.acj = i;
    }

    public String wt() {
        return this.acx;
    }

    public void dB(String str) {
        this.acx = str;
    }

    public HashMap<String, String> wu() {
        return this.acz;
    }

    public String wv() {
        return this.acD;
    }

    public void dC(String str) {
        this.acD = str;
    }

    public int ww() {
        return this.acf;
    }

    public int wx() {
        return this.acg;
    }

    public void cR(int i) {
        this.acf = i;
    }

    public void cS(int i) {
        this.acg = i;
    }

    public void dD(String str) {
        this.acG = str;
    }

    public void dE(String str) {
        this.acH = str;
    }

    public int wy() {
        return this.aco;
    }

    public void cT(int i) {
        this.aco = i;
    }

    public int wz() {
        return this.acp;
    }

    public void cU(int i) {
        this.acp = i;
    }

    public List<i> wA() {
        return this.acI;
    }

    public int wB() {
        return this.acq;
    }

    public void cV(int i) {
        this.acq = i;
    }
}
