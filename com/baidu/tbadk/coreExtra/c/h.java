package com.baidu.tbadk.coreExtra.c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class h {
    private String SA;
    private String SB;
    private String SC;
    private String Sr;
    private String Ss;
    private String St;
    private String Su;
    private String Sx;
    private String Sy;
    private String Sz;
    private int RX = 0;
    private int RY = 0;
    private int RZ = 0;
    private int Sa = 0;
    private int Sb = 0;
    private int Sc = 0;
    private int Sd = 0;
    private int Se = 0;
    private int Sf = 0;
    private int Sg = 0;
    private int Sh = 0;
    private int Si = 0;
    private int Sj = 0;
    private int Sk = 0;
    private int Sl = 0;
    private int Sm = 0;
    private int Sn = 0;
    private int So = 0;
    private boolean Sp = true;
    private boolean Sq = true;
    private HashMap<String, String> Sv = new HashMap<>();
    private HashMap<String, String> Sw = new HashMap<>();
    private String SD = null;
    private String SE = null;
    private List<i> SF = new ArrayList();

    public void sC() {
        HashMap<String, String> sS = sS();
        Set<String> keySet = sS.keySet();
        if (keySet.size() != 1) {
            dn(null);
        } else {
            dn(sS.get(keySet.iterator().next()));
        }
    }

    public void sD() {
        HashMap<String, String> sY = sY();
        Set<String> keySet = sY.keySet();
        if (keySet.size() != 1) {
            du(null);
        } else {
            du(sY.get(keySet.iterator().next()));
        }
    }

    public int sE() {
        return this.RX;
    }

    public void cF(int i) {
        this.RX = i;
    }

    public int sF() {
        return this.Sa;
    }

    public void cG(int i) {
        this.Sa = i;
    }

    public int sG() {
        return this.Sb;
    }

    public int sH() {
        return this.Sf;
    }

    public void cH(int i) {
        this.Sf = i;
    }

    public int sI() {
        return this.Sj;
    }

    public void cI(int i) {
        this.Sj = i;
    }

    public int sJ() {
        return this.Si;
    }

    public void cJ(int i) {
        this.Si = i;
    }

    public int sK() {
        return this.RX;
    }

    public int sL() {
        return this.RZ;
    }

    public void cK(int i) {
        this.RZ = i;
    }

    public boolean sM() {
        return this.Sp;
    }

    public void ax(boolean z) {
        this.Sp = z;
    }

    public String sN() {
        return this.Sr;
    }

    public void dm(String str) {
        this.Sr = str;
    }

    public String sO() {
        return this.Sx;
    }

    public void dn(String str) {
        this.Sx = str;
    }

    public void dp(String str) {
        this.Sy = str;
    }

    public int sP() {
        return this.RY;
    }

    public void cL(int i) {
        this.RY = i;
    }

    public void dq(String str) {
        this.Sz = str;
    }

    public String sQ() {
        return this.SB;
    }

    public String sR() {
        return this.SC;
    }

    public HashMap<String, String> sS() {
        return this.Sv;
    }

    public int sT() {
        return this.Sc;
    }

    public void cM(int i) {
        this.Sc = i;
    }

    public int sU() {
        return this.Sg;
    }

    public void cN(int i) {
        this.Sg = i;
    }

    public int sV() {
        return this.Sk;
    }

    public void cO(int i) {
        this.Sk = i;
    }

    public void dr(String str) {
        this.Ss = str;
    }

    public void ds(String str) {
        this.St = str;
    }

    public int sW() {
        return this.Sh;
    }

    public void cP(int i) {
        this.Sh = i;
    }

    public String sX() {
        return this.Su;
    }

    public void dt(String str) {
        this.Su = str;
    }

    public HashMap<String, String> sY() {
        return this.Sw;
    }

    public String sZ() {
        return this.SA;
    }

    public void du(String str) {
        this.SA = str;
    }

    public int ta() {
        return this.Sd;
    }

    public int tb() {
        return this.Se;
    }

    public void cQ(int i) {
        this.Sd = i;
    }

    public void cR(int i) {
        this.Se = i;
    }

    public void dv(String str) {
        this.SD = str;
    }

    public void dw(String str) {
        this.SE = str;
    }

    public int tc() {
        return this.Sm;
    }

    public void cS(int i) {
        this.Sm = i;
    }

    public int td() {
        return this.Sn;
    }

    public void cT(int i) {
        this.Sn = i;
    }

    public List<i> te() {
        return this.SF;
    }

    public int tf() {
        return this.So;
    }

    public void cU(int i) {
        this.So = i;
    }
}
