package com.baidu.tieba.ala.data;
/* loaded from: classes3.dex */
public class l {
    private String aAL;
    private int fEf;
    private String fEg;
    private String fEh;
    private String feD;
    private String fep;
    private String mIcon;
    private String mName;
    public int mStatus;

    public l() {
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.fEg = str;
        this.mIcon = str2;
        this.mName = str3;
        this.fEh = str4;
        this.feD = str5;
        this.fep = str6;
        this.aAL = str7;
        this.mStatus = i;
    }

    public int bwA() {
        return this.fEf;
    }

    public void qG(int i) {
        this.fEf = i;
    }

    public String bwB() {
        return this.fEg;
    }

    public String bwC() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bwD() {
        return this.fEh;
    }

    public String bwE() {
        return this.feD;
    }

    public String bwF() {
        return this.fep;
    }
}
