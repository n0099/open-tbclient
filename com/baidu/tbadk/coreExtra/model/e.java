package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String ciC;
    private String ciD;
    private String ciE;
    private String ciF;
    private String ciG;
    private String ciH;
    private String ciw;
    private String cix;
    private String ciy;
    private String ciz;
    private int cie = 0;
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
    private boolean ciu = true;
    private boolean civ = true;
    private HashMap<String, String> ciA = new HashMap<>();
    private HashMap<String, String> ciB = new HashMap<>();
    private List<a> ciI = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String ciJ;
        public String ciK;
        public int ciL;
        public String ciM;
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
            pa(null);
        } else {
            pa(aok.get(keySet.iterator().next()));
        }
    }

    public void anV() {
        HashMap<String, String> aoq = aoq();
        Set<String> keySet = aoq.keySet();
        if (keySet.size() != 1) {
            pg(null);
        } else {
            pg(aoq.get(keySet.iterator().next()));
        }
    }

    public int anW() {
        return this.cie;
    }

    public void jt(int i) {
        this.cie = i;
    }

    public int anX() {
        return this.cih;
    }

    public void ju(int i) {
        this.cih = i;
    }

    public int anY() {
        return this.cii;
    }

    public int anZ() {
        return this.cik;
    }

    public void jv(int i) {
        this.cik = i;
    }

    public int aoa() {
        return this.cio;
    }

    public void jw(int i) {
        this.cio = i;
    }

    public int aob() {
        return this.cin;
    }

    public void jx(int i) {
        this.cin = i;
    }

    public int aoc() {
        return this.cie;
    }

    public int aod() {
        return this.cig;
    }

    public void jy(int i) {
        this.cig = i;
    }

    public boolean aoe() {
        return this.ciu;
    }

    public void eL(boolean z) {
        this.ciu = z;
    }

    public String aof() {
        return this.ciw;
    }

    public void oZ(String str) {
        this.ciw = str;
    }

    public String aog() {
        return this.ciC;
    }

    public void pa(String str) {
        this.ciC = str;
    }

    public void pb(String str) {
        this.ciD = str;
    }

    public int aoh() {
        return this.cif;
    }

    public void jz(int i) {
        this.cif = i;
    }

    public void pc(String str) {
        this.ciE = str;
    }

    public String aoi() {
        return this.ciG;
    }

    public String aoj() {
        return this.ciH;
    }

    public HashMap<String, String> aok() {
        return this.ciA;
    }

    public int aol() {
        return this.cij;
    }

    public void jA(int i) {
        this.cij = i;
    }

    public int aom() {
        return this.cil;
    }

    public void jB(int i) {
        this.cil = i;
    }

    public int aon() {
        return this.cip;
    }

    public void jC(int i) {
        this.cip = i;
    }

    public void pd(String str) {
        this.cix = str;
    }

    public void pe(String str) {
        this.ciy = str;
    }

    public int aoo() {
        return this.cim;
    }

    public void jD(int i) {
        this.cim = i;
    }

    public String aop() {
        return this.ciz;
    }

    public void pf(String str) {
        this.ciz = str;
    }

    public HashMap<String, String> aoq() {
        return this.ciB;
    }

    public String aor() {
        return this.ciF;
    }

    public void pg(String str) {
        this.ciF = str;
    }

    public int aos() {
        return this.cir;
    }

    public void jE(int i) {
        this.cir = i;
    }

    public int aot() {
        return this.cis;
    }

    public void jF(int i) {
        this.cis = i;
    }

    public List<a> aou() {
        return this.ciI;
    }

    public int aov() {
        return this.cit;
    }

    public void jG(int i) {
        this.cit = i;
    }
}
