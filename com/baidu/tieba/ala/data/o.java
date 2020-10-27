package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class o {
    private String aMj;
    private String fSR;
    private String fSw;
    private int guI;
    private String guJ;
    private String guK;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.guJ = str;
        this.mIcon = str2;
        this.mName = str3;
        this.guK = str4;
        this.fSR = str5;
        this.fSw = str6;
        this.aMj = str7;
        this.mStatus = i;
    }

    public int bPt() {
        return this.guI;
    }

    public void ur(int i) {
        this.guI = i;
    }

    public String bPu() {
        return this.guJ;
    }

    public String bPv() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bPw() {
        return this.guK;
    }

    public String bPx() {
        return this.fSR;
    }

    public String bPy() {
        return this.fSw;
    }
}
