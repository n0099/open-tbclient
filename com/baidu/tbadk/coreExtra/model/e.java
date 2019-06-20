package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ciA;
    private String ciD;
    private String ciE;
    private String ciF;
    private String ciG;
    private String ciH;
    private String ciI;
    private String cix;
    private String ciy;
    private String ciz;
    private int cif = 0;
    private int cig = 0;
    private int cih = 0;
    private int cii = 0;
    private int cij = 0;
    private int cik = 0;
    private int cil = 0;
    private int cim = 0;
    private int cin = 0;
    private int cio = 0;
    private int cip = 0;
    private int ciq = 0;
    private int cir = 0;
    private int cis = 0;
    private int cit = 0;
    private int ciu = 0;
    private boolean civ = true;
    private boolean ciw = true;
    private HashMap<String, String> ciB = new HashMap<>();
    private HashMap<String, String> ciC = new HashMap<>();
    private List<a> ciJ = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String ciK;
        public String ciL;
        public int ciM;
        public String ciN;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void anU() {
        HashMap<String, String> aok = aok();
        Set<String> keySet = aok.keySet();
        if (keySet.size() != 1) {
            oZ(null);
        } else {
            oZ(aok.get(keySet.iterator().next()));
        }
    }

    public void anV() {
        HashMap<String, String> aoq = aoq();
        Set<String> keySet = aoq.keySet();
        if (keySet.size() != 1) {
            pf(null);
        } else {
            pf(aoq.get(keySet.iterator().next()));
        }
    }

    public int anW() {
        return this.cif;
    }

    public void jt(int i) {
        this.cif = i;
    }

    public int anX() {
        return this.cii;
    }

    public void ju(int i) {
        this.cii = i;
    }

    public int anY() {
        return this.cij;
    }

    public int anZ() {
        return this.cil;
    }

    public void jv(int i) {
        this.cil = i;
    }

    public int aoa() {
        return this.cip;
    }

    public void jw(int i) {
        this.cip = i;
    }

    public int aob() {
        return this.cio;
    }

    public void jx(int i) {
        this.cio = i;
    }

    public int aoc() {
        return this.cif;
    }

    public int aod() {
        return this.cih;
    }

    public void jy(int i) {
        this.cih = i;
    }

    public boolean aoe() {
        return this.civ;
    }

    public void eL(boolean z) {
        this.civ = z;
    }

    public String aof() {
        return this.cix;
    }

    public void oY(String str) {
        this.cix = str;
    }

    public String aog() {
        return this.ciD;
    }

    public void oZ(String str) {
        this.ciD = str;
    }

    public void pa(String str) {
        this.ciE = str;
    }

    public int aoh() {
        return this.cig;
    }

    public void jz(int i) {
        this.cig = i;
    }

    public void pb(String str) {
        this.ciF = str;
    }

    public String aoi() {
        return this.ciH;
    }

    public String aoj() {
        return this.ciI;
    }

    public HashMap<String, String> aok() {
        return this.ciB;
    }

    public int aol() {
        return this.cik;
    }

    public void jA(int i) {
        this.cik = i;
    }

    public int aom() {
        return this.cim;
    }

    public void jB(int i) {
        this.cim = i;
    }

    public int aon() {
        return this.ciq;
    }

    public void jC(int i) {
        this.ciq = i;
    }

    public void pc(String str) {
        this.ciy = str;
    }

    public void pd(String str) {
        this.ciz = str;
    }

    public int aoo() {
        return this.cin;
    }

    public void jD(int i) {
        this.cin = i;
    }

    public String aop() {
        return this.ciA;
    }

    public void pe(String str) {
        this.ciA = str;
    }

    public HashMap<String, String> aoq() {
        return this.ciC;
    }

    public String aor() {
        return this.ciG;
    }

    public void pf(String str) {
        this.ciG = str;
    }

    public int aos() {
        return this.cis;
    }

    public void jE(int i) {
        this.cis = i;
    }

    public int aot() {
        return this.cit;
    }

    public void jF(int i) {
        this.cit = i;
    }

    public List<a> aou() {
        return this.ciJ;
    }

    public int aov() {
        return this.ciu;
    }

    public void jG(int i) {
        this.ciu = i;
    }
}
