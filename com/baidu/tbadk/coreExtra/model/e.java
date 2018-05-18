package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String awb;
    private String awc;
    private String awd;
    private String awe;
    private String awh;
    private String awi;
    private String awj;
    private String awk;
    private String awl;
    private String awm;
    private int avJ = 0;
    private int avK = 0;
    private int avL = 0;
    private int avM = 0;
    private int avN = 0;
    private int avO = 0;
    private int avP = 0;
    private int avQ = 0;
    private int avR = 0;
    private int avS = 0;
    private int avT = 0;
    private int avU = 0;
    private int avV = 0;
    private int avW = 0;
    private int avX = 0;
    private int avY = 0;
    private boolean avZ = true;
    private boolean awa = true;
    private HashMap<String, String> awf = new HashMap<>();
    private HashMap<String, String> awg = new HashMap<>();
    private List<a> awn = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String awo;
        public String awp;
        public int awq;
        public String awr;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void AN() {
        HashMap<String, String> Bd = Bd();
        Set<String> keySet = Bd.keySet();
        if (keySet.size() != 1) {
            fm(null);
        } else {
            fm(Bd.get(keySet.iterator().next()));
        }
    }

    public void AO() {
        HashMap<String, String> Bj = Bj();
        Set<String> keySet = Bj.keySet();
        if (keySet.size() != 1) {
            fs(null);
        } else {
            fs(Bj.get(keySet.iterator().next()));
        }
    }

    public int AP() {
        return this.avJ;
    }

    public void dX(int i) {
        this.avJ = i;
    }

    public int AQ() {
        return this.avM;
    }

    public void dY(int i) {
        this.avM = i;
    }

    public int AR() {
        return this.avN;
    }

    public int AS() {
        return this.avP;
    }

    public void dZ(int i) {
        this.avP = i;
    }

    public int AT() {
        return this.avT;
    }

    public void ea(int i) {
        this.avT = i;
    }

    public int AU() {
        return this.avS;
    }

    public void eb(int i) {
        this.avS = i;
    }

    public int AV() {
        return this.avJ;
    }

    public int AW() {
        return this.avL;
    }

    public void ec(int i) {
        this.avL = i;
    }

    public boolean AX() {
        return this.avZ;
    }

    public void bl(boolean z) {
        this.avZ = z;
    }

    public String AY() {
        return this.awb;
    }

    public void fl(String str) {
        this.awb = str;
    }

    public String AZ() {
        return this.awh;
    }

    public void fm(String str) {
        this.awh = str;
    }

    public void fn(String str) {
        this.awi = str;
    }

    public int Ba() {
        return this.avK;
    }

    public void ed(int i) {
        this.avK = i;
    }

    public void fo(String str) {
        this.awj = str;
    }

    public String Bb() {
        return this.awl;
    }

    public String Bc() {
        return this.awm;
    }

    public HashMap<String, String> Bd() {
        return this.awf;
    }

    public int Be() {
        return this.avO;
    }

    public void ee(int i) {
        this.avO = i;
    }

    public int Bf() {
        return this.avQ;
    }

    public void ef(int i) {
        this.avQ = i;
    }

    public int Bg() {
        return this.avU;
    }

    public void eg(int i) {
        this.avU = i;
    }

    public void fp(String str) {
        this.awc = str;
    }

    public void fq(String str) {
        this.awd = str;
    }

    public int Bh() {
        return this.avR;
    }

    public void eh(int i) {
        this.avR = i;
    }

    public String Bi() {
        return this.awe;
    }

    public void fr(String str) {
        this.awe = str;
    }

    public HashMap<String, String> Bj() {
        return this.awg;
    }

    public String Bk() {
        return this.awk;
    }

    public void fs(String str) {
        this.awk = str;
    }

    public int Bl() {
        return this.avW;
    }

    public void ei(int i) {
        this.avW = i;
    }

    public int Bm() {
        return this.avX;
    }

    public void ej(int i) {
        this.avX = i;
    }

    public List<a> Bn() {
        return this.awn;
    }

    public int Bo() {
        return this.avY;
    }

    public void ek(int i) {
        this.avY = i;
    }
}
