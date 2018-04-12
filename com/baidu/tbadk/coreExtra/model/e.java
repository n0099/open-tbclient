package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String awa;
    private String awb;
    private String awc;
    private String awd;
    private String awg;
    private String awh;
    private String awi;
    private String awj;
    private String awk;
    private String awl;
    private int avI = 0;
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
    private boolean avY = true;
    private boolean avZ = true;
    private HashMap<String, String> awe = new HashMap<>();
    private HashMap<String, String> awf = new HashMap<>();
    private List<a> awm = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String awn;
        public String awo;
        public int awp;
        public String awq;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void AP() {
        HashMap<String, String> Bf = Bf();
        Set<String> keySet = Bf.keySet();
        if (keySet.size() != 1) {
            fm(null);
        } else {
            fm(Bf.get(keySet.iterator().next()));
        }
    }

    public void AQ() {
        HashMap<String, String> Bl = Bl();
        Set<String> keySet = Bl.keySet();
        if (keySet.size() != 1) {
            fs(null);
        } else {
            fs(Bl.get(keySet.iterator().next()));
        }
    }

    public int AR() {
        return this.avI;
    }

    public void dX(int i) {
        this.avI = i;
    }

    public int AS() {
        return this.avL;
    }

    public void dY(int i) {
        this.avL = i;
    }

    public int AT() {
        return this.avM;
    }

    public int AU() {
        return this.avO;
    }

    public void dZ(int i) {
        this.avO = i;
    }

    public int AV() {
        return this.avS;
    }

    public void ea(int i) {
        this.avS = i;
    }

    public int AW() {
        return this.avR;
    }

    public void eb(int i) {
        this.avR = i;
    }

    public int AX() {
        return this.avI;
    }

    public int AY() {
        return this.avK;
    }

    public void ec(int i) {
        this.avK = i;
    }

    public boolean AZ() {
        return this.avY;
    }

    public void bl(boolean z) {
        this.avY = z;
    }

    public String Ba() {
        return this.awa;
    }

    public void fl(String str) {
        this.awa = str;
    }

    public String Bb() {
        return this.awg;
    }

    public void fm(String str) {
        this.awg = str;
    }

    public void fn(String str) {
        this.awh = str;
    }

    public int Bc() {
        return this.avJ;
    }

    public void ed(int i) {
        this.avJ = i;
    }

    public void fo(String str) {
        this.awi = str;
    }

    public String Bd() {
        return this.awk;
    }

    public String Be() {
        return this.awl;
    }

    public HashMap<String, String> Bf() {
        return this.awe;
    }

    public int Bg() {
        return this.avN;
    }

    public void ee(int i) {
        this.avN = i;
    }

    public int Bh() {
        return this.avP;
    }

    public void ef(int i) {
        this.avP = i;
    }

    public int Bi() {
        return this.avT;
    }

    public void eg(int i) {
        this.avT = i;
    }

    public void fp(String str) {
        this.awb = str;
    }

    public void fq(String str) {
        this.awc = str;
    }

    public int Bj() {
        return this.avQ;
    }

    public void eh(int i) {
        this.avQ = i;
    }

    public String Bk() {
        return this.awd;
    }

    public void fr(String str) {
        this.awd = str;
    }

    public HashMap<String, String> Bl() {
        return this.awf;
    }

    public String Bm() {
        return this.awj;
    }

    public void fs(String str) {
        this.awj = str;
    }

    public int Bn() {
        return this.avV;
    }

    public void ei(int i) {
        this.avV = i;
    }

    public int Bo() {
        return this.avW;
    }

    public void ej(int i) {
        this.avW = i;
    }

    public List<a> Bp() {
        return this.awm;
    }

    public int Bq() {
        return this.avX;
    }

    public void ek(int i) {
        this.avX = i;
    }
}
