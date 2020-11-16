package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class o {
    private String aLy;
    private String fXT;
    private String fYo;
    private int gAd;
    private String gAe;
    private String gAf;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gAe = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gAf = str4;
        this.fYo = str5;
        this.fXT = str6;
        this.aLy = str7;
        this.mStatus = i;
    }

    public int bRm() {
        return this.gAd;
    }

    public void uZ(int i) {
        this.gAd = i;
    }

    public String bRn() {
        return this.gAe;
    }

    public String bRo() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bRp() {
        return this.gAf;
    }

    public String bRq() {
        return this.fYo;
    }

    public String bRr() {
        return this.fXT;
    }
}
