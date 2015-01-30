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
    private String SD;
    private String SE;
    private String SF;
    private String Su;
    private String Sv;
    private String Sw;
    private String Sx;
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
    private int Sp = 0;
    private int Sq = 0;
    private int Sr = 0;
    private boolean Ss = true;
    private boolean St = true;
    private HashMap<String, String> Sy = new HashMap<>();
    private HashMap<String, String> Sz = new HashMap<>();
    private String SG = null;
    private String SH = null;
    private List<i> SI = new ArrayList();

    public void sI() {
        HashMap<String, String> sY = sY();
        Set<String> keySet = sY.keySet();
        if (keySet.size() != 1) {
            dr(null);
        } else {
            dr(sY.get(keySet.iterator().next()));
        }
    }

    public void sJ() {
        HashMap<String, String> te = te();
        Set<String> keySet = te.keySet();
        if (keySet.size() != 1) {
            dx(null);
        } else {
            dx(te.get(keySet.iterator().next()));
        }
    }

    public int sK() {
        return this.Sa;
    }

    public void cF(int i) {
        this.Sa = i;
    }

    public int sL() {
        return this.Sd;
    }

    public void cG(int i) {
        this.Sd = i;
    }

    public int sM() {
        return this.Se;
    }

    public int sN() {
        return this.Si;
    }

    public void cH(int i) {
        this.Si = i;
    }

    public int sO() {
        return this.Sm;
    }

    public void cI(int i) {
        this.Sm = i;
    }

    public int sP() {
        return this.Sl;
    }

    public void cJ(int i) {
        this.Sl = i;
    }

    public int sQ() {
        return this.Sa;
    }

    public int sR() {
        return this.Sc;
    }

    public void cK(int i) {
        this.Sc = i;
    }

    public boolean sS() {
        return this.Ss;
    }

    public void ax(boolean z) {
        this.Ss = z;
    }

    public String sT() {
        return this.Su;
    }

    public void dq(String str) {
        this.Su = str;
    }

    public String sU() {
        return this.SA;
    }

    public void dr(String str) {
        this.SA = str;
    }

    public void ds(String str) {
        this.SB = str;
    }

    public int sV() {
        return this.Sb;
    }

    public void cL(int i) {
        this.Sb = i;
    }

    public void dt(String str) {
        this.SC = str;
    }

    public String sW() {
        return this.SE;
    }

    public String sX() {
        return this.SF;
    }

    public HashMap<String, String> sY() {
        return this.Sy;
    }

    public int sZ() {
        return this.Sf;
    }

    public void cM(int i) {
        this.Sf = i;
    }

    public int ta() {
        return this.Sj;
    }

    public void cN(int i) {
        this.Sj = i;
    }

    public int tb() {
        return this.Sn;
    }

    public void cO(int i) {
        this.Sn = i;
    }

    public void du(String str) {
        this.Sv = str;
    }

    public void dv(String str) {
        this.Sw = str;
    }

    public int tc() {
        return this.Sk;
    }

    public void cP(int i) {
        this.Sk = i;
    }

    public String td() {
        return this.Sx;
    }

    public void dw(String str) {
        this.Sx = str;
    }

    public HashMap<String, String> te() {
        return this.Sz;
    }

    public String tf() {
        return this.SD;
    }

    public void dx(String str) {
        this.SD = str;
    }

    public int tg() {
        return this.Sg;
    }

    public int th() {
        return this.Sh;
    }

    public void cQ(int i) {
        this.Sg = i;
    }

    public void cR(int i) {
        this.Sh = i;
    }

    public void dy(String str) {
        this.SG = str;
    }

    public void dz(String str) {
        this.SH = str;
    }

    public int ti() {
        return this.Sp;
    }

    public void cS(int i) {
        this.Sp = i;
    }

    public int tj() {
        return this.Sq;
    }

    public void cT(int i) {
        this.Sq = i;
    }

    public List<i> tk() {
        return this.SI;
    }

    public int tl() {
        return this.Sr;
    }

    public void cU(int i) {
        this.Sr = i;
    }
}
