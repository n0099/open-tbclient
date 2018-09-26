package com.baidu.tbadk.coreExtra.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    private String aIA;
    private String aIB;
    private String aIC;
    private String aID;
    private String aIE;
    private String aIt;
    private String aIu;
    private String aIv;
    private String aIw;
    private String aIz;
    private int aIb = 0;
    private int aIc = 0;
    private int aId = 0;
    private int aIe = 0;
    private int aIf = 0;
    private int aIg = 0;
    private int aIh = 0;
    private int aIi = 0;
    private int aIj = 0;
    private int aIk = 0;
    private int aIl = 0;
    private int aIm = 0;
    private int aIn = 0;
    private int aIo = 0;
    private int aIp = 0;
    private int aIq = 0;
    private boolean aIr = true;
    private boolean aIs = true;
    private HashMap<String, String> aIx = new HashMap<>();
    private HashMap<String, String> aIy = new HashMap<>();
    private List<a> aIF = new ArrayList();

    /* loaded from: classes.dex */
    public static class a {
        public String aIG;
        public String aIH;
        public int aII;
        public String aIJ;
        public String content;
        public String gid;
        public String title;
        public int unReadCount;
        public int userType;
    }

    public void FS() {
        HashMap<String, String> Gi = Gi();
        Set<String> keySet = Gi.keySet();
        if (keySet.size() != 1) {
            gh(null);
        } else {
            gh(Gi.get(keySet.iterator().next()));
        }
    }

    public void FT() {
        HashMap<String, String> Go = Go();
        Set<String> keySet = Go.keySet();
        if (keySet.size() != 1) {
            gn(null);
        } else {
            gn(Go.get(keySet.iterator().next()));
        }
    }

    public int FU() {
        return this.aIb;
    }

    public void eo(int i) {
        this.aIb = i;
    }

    public int FV() {
        return this.aIe;
    }

    public void ep(int i) {
        this.aIe = i;
    }

    public int FW() {
        return this.aIf;
    }

    public int FX() {
        return this.aIh;
    }

    public void eq(int i) {
        this.aIh = i;
    }

    public int FY() {
        return this.aIl;
    }

    public void er(int i) {
        this.aIl = i;
    }

    public int FZ() {
        return this.aIk;
    }

    public void es(int i) {
        this.aIk = i;
    }

    public int Ga() {
        return this.aIb;
    }

    public int Gb() {
        return this.aId;
    }

    public void et(int i) {
        this.aId = i;
    }

    public boolean Gc() {
        return this.aIr;
    }

    public void bD(boolean z) {
        this.aIr = z;
    }

    public String Gd() {
        return this.aIt;
    }

    public void gg(String str) {
        this.aIt = str;
    }

    public String Ge() {
        return this.aIz;
    }

    public void gh(String str) {
        this.aIz = str;
    }

    public void gi(String str) {
        this.aIA = str;
    }

    public int Gf() {
        return this.aIc;
    }

    public void eu(int i) {
        this.aIc = i;
    }

    public void gj(String str) {
        this.aIB = str;
    }

    public String Gg() {
        return this.aID;
    }

    public String Gh() {
        return this.aIE;
    }

    public HashMap<String, String> Gi() {
        return this.aIx;
    }

    public int Gj() {
        return this.aIg;
    }

    public void ev(int i) {
        this.aIg = i;
    }

    public int Gk() {
        return this.aIi;
    }

    public void ew(int i) {
        this.aIi = i;
    }

    public int Gl() {
        return this.aIm;
    }

    public void ex(int i) {
        this.aIm = i;
    }

    public void gk(String str) {
        this.aIu = str;
    }

    public void gl(String str) {
        this.aIv = str;
    }

    public int Gm() {
        return this.aIj;
    }

    public void ey(int i) {
        this.aIj = i;
    }

    public String Gn() {
        return this.aIw;
    }

    public void gm(String str) {
        this.aIw = str;
    }

    public HashMap<String, String> Go() {
        return this.aIy;
    }

    public String Gp() {
        return this.aIC;
    }

    public void gn(String str) {
        this.aIC = str;
    }

    public int Gq() {
        return this.aIo;
    }

    public void ez(int i) {
        this.aIo = i;
    }

    public int Gr() {
        return this.aIp;
    }

    public void eA(int i) {
        this.aIp = i;
    }

    public List<a> Gs() {
        return this.aIF;
    }

    public int Gt() {
        return this.aIq;
    }

    public void eB(int i) {
        this.aIq = i;
    }
}
