package com.baidu.tieba.ala.data;
/* loaded from: classes3.dex */
public class l {
    private String ayw;
    private String eUe;
    private String eUs;
    private int fsU;
    private String fsV;
    private String fsW;
    private String mIcon;
    private String mName;
    public int mStatus;

    public l() {
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.fsV = str;
        this.mIcon = str2;
        this.mName = str3;
        this.fsW = str4;
        this.eUs = str5;
        this.eUe = str6;
        this.ayw = str7;
        this.mStatus = i;
    }

    public int btF() {
        return this.fsU;
    }

    public void qh(int i) {
        this.fsU = i;
    }

    public String btG() {
        return this.fsV;
    }

    public String btH() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String btI() {
        return this.fsW;
    }

    public String btJ() {
        return this.eUs;
    }

    public String btK() {
        return this.eUe;
    }
}
