package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class m {
    private String aBY;
    private int fJA;
    private String fJB;
    private String fJC;
    private String fjG;
    private String fji;
    private String mIcon;
    private String mName;
    public int mStatus;

    public m() {
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.fJB = str;
        this.mIcon = str2;
        this.mName = str3;
        this.fJC = str4;
        this.fjG = str5;
        this.fji = str6;
        this.aBY = str7;
        this.mStatus = i;
    }

    public int bzR() {
        return this.fJA;
    }

    public void qW(int i) {
        this.fJA = i;
    }

    public String bzS() {
        return this.fJB;
    }

    public String bzT() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bzU() {
        return this.fJC;
    }

    public String bzV() {
        return this.fjG;
    }

    public String bzW() {
        return this.fji;
    }
}
