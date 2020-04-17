package com.baidu.tieba.ala.data;
/* loaded from: classes3.dex */
public class l {
    private String ats;
    private String eHE;
    private String eHq;
    private int feZ;
    private String ffa;
    private String ffb;
    private String mIcon;
    private String mName;
    public int mStatus;

    public l() {
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.ffa = str;
        this.mIcon = str2;
        this.mName = str3;
        this.ffb = str4;
        this.eHE = str5;
        this.eHq = str6;
        this.ats = str7;
        this.mStatus = i;
    }

    public int bnN() {
        return this.feZ;
    }

    public void pE(int i) {
        this.feZ = i;
    }

    public String bnO() {
        return this.ffa;
    }

    public String bnP() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bnQ() {
        return this.ffb;
    }

    public String bnR() {
        return this.eHE;
    }

    public String bnS() {
        return this.eHq;
    }
}
