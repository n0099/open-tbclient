package com.baidu.tieba.ala.data;
/* loaded from: classes2.dex */
public class l {
    private String YP;
    private String ecK;
    private String ecZ;
    private int euA;
    private String euB;
    private String euC;
    private String mIcon;
    private String mName;
    public int mStatus;

    public l() {
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.euB = str;
        this.mIcon = str2;
        this.mName = str3;
        this.euC = str4;
        this.ecZ = str5;
        this.ecK = str6;
        this.YP = str7;
        this.mStatus = i;
    }

    public int bbF() {
        return this.euA;
    }

    public void oP(int i) {
        this.euA = i;
    }

    public String bbG() {
        return this.euB;
    }

    public String bbH() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bbI() {
        return this.euC;
    }

    public String bbJ() {
        return this.ecZ;
    }

    public String bbK() {
        return this.ecK;
    }
}
