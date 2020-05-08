package com.baidu.tieba.ala.data;
/* loaded from: classes3.dex */
public class l {
    private String aty;
    private String eHJ;
    private String eHv;
    private int ffe;
    private String fff;
    private String ffg;
    private String mIcon;
    private String mName;
    public int mStatus;

    public l() {
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.fff = str;
        this.mIcon = str2;
        this.mName = str3;
        this.ffg = str4;
        this.eHJ = str5;
        this.eHv = str6;
        this.aty = str7;
        this.mStatus = i;
    }

    public int bnL() {
        return this.ffe;
    }

    public void pE(int i) {
        this.ffe = i;
    }

    public String bnM() {
        return this.fff;
    }

    public String bnN() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bnO() {
        return this.ffg;
    }

    public String bnP() {
        return this.eHJ;
    }

    public String bnQ() {
        return this.eHv;
    }
}
