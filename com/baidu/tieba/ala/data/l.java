package com.baidu.tieba.ala.data;
/* loaded from: classes3.dex */
public class l {
    private String ayw;
    private String eTT;
    private String eUh;
    private int fsJ;
    private String fsK;
    private String fsL;
    private String mIcon;
    private String mName;
    public int mStatus;

    public l() {
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.fsK = str;
        this.mIcon = str2;
        this.mName = str3;
        this.fsL = str4;
        this.eUh = str5;
        this.eTT = str6;
        this.ayw = str7;
        this.mStatus = i;
    }

    public int btD() {
        return this.fsJ;
    }

    public void qf(int i) {
        this.fsJ = i;
    }

    public String btE() {
        return this.fsK;
    }

    public String btF() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String btG() {
        return this.fsL;
    }

    public String btH() {
        return this.eUh;
    }

    public String btI() {
        return this.eTT;
    }
}
