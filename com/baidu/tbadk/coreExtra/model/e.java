package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aNL;
    private String aNM;
    private String aNN;
    private String aNO;
    private String aNR;
    private String aNS;
    private String aNT;
    private String aNU;
    private String aNV;
    private String aNW;
    private int aNt = 0;
    private int aNu = 0;
    private int aNv = 0;
    private int aNw = 0;
    private int aNx = 0;
    private int aNy = 0;
    private int aNz = 0;
    private int aNA = 0;
    private int aNB = 0;
    private int aNC = 0;
    private int aND = 0;
    private int aNE = 0;
    private int aNF = 0;
    private int aNG = 0;
    private int aNH = 0;
    private int aNI = 0;
    private boolean aNJ = true;
    private boolean aNK = true;
    private HashMap<String, String> aNP = new HashMap<>();
    private HashMap<String, String> aNQ = new HashMap<>();
    private List<a> aNX = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aNY;
        public String aNZ;
        public int aOa;
        public String aOb;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void If() {
        HashMap<String, String> Iv = Iv();
        Set<String> keySet = Iv.keySet();
        if (keySet.size() != 1) {
            gx(null);
        } else {
            gx(Iv.get(keySet.iterator().next()));
        }
    }

    public void Ig() {
        HashMap<String, String> IB = IB();
        Set<String> keySet = IB.keySet();
        if (keySet.size() != 1) {
            gD(null);
        } else {
            gD(IB.get(keySet.iterator().next()));
        }
    }

    public int Ih() {
        return this.aNt;
    }

    public void eL(int i) {
        this.aNt = i;
    }

    public int Ii() {
        return this.aNw;
    }

    public void eM(int i) {
        this.aNw = i;
    }

    public int Ij() {
        return this.aNx;
    }

    public int Ik() {
        return this.aNz;
    }

    public void eN(int i) {
        this.aNz = i;
    }

    public int Il() {
        return this.aND;
    }

    public void eO(int i) {
        this.aND = i;
    }

    public int Im() {
        return this.aNC;
    }

    public void eP(int i) {
        this.aNC = i;
    }

    public int In() {
        return this.aNt;
    }

    public int Io() {
        return this.aNv;
    }

    public void eQ(int i) {
        this.aNv = i;
    }

    public boolean Ip() {
        return this.aNJ;
    }

    public void cd(boolean z) {
        this.aNJ = z;
    }

    public String Iq() {
        return this.aNL;
    }

    public void gw(String str) {
        this.aNL = str;
    }

    public String Ir() {
        return this.aNR;
    }

    public void gx(String str) {
        this.aNR = str;
    }

    public void gy(String str) {
        this.aNS = str;
    }

    public int Is() {
        return this.aNu;
    }

    public void eR(int i) {
        this.aNu = i;
    }

    public void gz(String str) {
        this.aNT = str;
    }

    public String It() {
        return this.aNV;
    }

    public String Iu() {
        return this.aNW;
    }

    public HashMap<String, String> Iv() {
        return this.aNP;
    }

    public int Iw() {
        return this.aNy;
    }

    public void eS(int i) {
        this.aNy = i;
    }

    public int Ix() {
        return this.aNA;
    }

    public void eT(int i) {
        this.aNA = i;
    }

    public int Iy() {
        return this.aNE;
    }

    public void eU(int i) {
        this.aNE = i;
    }

    public void gA(String str) {
        this.aNM = str;
    }

    public void gB(String str) {
        this.aNN = str;
    }

    public int Iz() {
        return this.aNB;
    }

    public void eV(int i) {
        this.aNB = i;
    }

    public String IA() {
        return this.aNO;
    }

    public void gC(String str) {
        this.aNO = str;
    }

    public HashMap<String, String> IB() {
        return this.aNQ;
    }

    public String IC() {
        return this.aNU;
    }

    public void gD(String str) {
        this.aNU = str;
    }

    public int ID() {
        return this.aNG;
    }

    public void eW(int i) {
        this.aNG = i;
    }

    public int IE() {
        return this.aNH;
    }

    public void eX(int i) {
        this.aNH = i;
    }

    public List<a> IF() {
        return this.aNX;
    }

    public int IG() {
        return this.aNI;
    }

    public void eY(int i) {
        this.aNI = i;
    }
}
