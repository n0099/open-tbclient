package com.baidu.tieba.ala.data;
/* loaded from: classes10.dex */
public class o {
    private String aOA;
    private int gUQ;
    private String gUR;
    private String gUS;
    private String gqD;
    private String gqY;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gUR = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gUS = str4;
        this.gqY = str5;
        this.gqD = str6;
        this.aOA = str7;
        this.mStatus = i;
    }

    public int bUD() {
        return this.gUQ;
    }

    public void ut(int i) {
        this.gUQ = i;
    }

    public String bUE() {
        return this.gUR;
    }

    public String bUF() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bUG() {
        return this.gUS;
    }

    public String bUH() {
        return this.gqY;
    }

    public String bUI() {
        return this.gqD;
    }
}
