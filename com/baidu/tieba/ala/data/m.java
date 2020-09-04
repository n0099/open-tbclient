package com.baidu.tieba.ala.data;
/* loaded from: classes7.dex */
public class m {
    private String aHk;
    private int fUV;
    private String fUW;
    private String fUX;
    private String fuI;
    private String fvg;
    private String mIcon;
    private String mName;
    public int mStatus;

    public m() {
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.fUW = str;
        this.mIcon = str2;
        this.mName = str3;
        this.fUX = str4;
        this.fvg = str5;
        this.fuI = str6;
        this.aHk = str7;
        this.mStatus = i;
    }

    public int bIV() {
        return this.fUV;
    }

    public void ti(int i) {
        this.fUV = i;
    }

    public String bIW() {
        return this.fUW;
    }

    public String bIX() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bIY() {
        return this.fUX;
    }

    public String bIZ() {
        return this.fvg;
    }

    public String bJa() {
        return this.fuI;
    }
}
