package com.baidu.tieba.ala.data;
/* loaded from: classes2.dex */
public class l {
    private String Zb;
    private String ecT;
    private String edh;
    private int evL;
    private String evM;
    private String evN;
    private String mIcon;
    private String mName;
    public int mStatus;

    public l() {
    }

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.evM = str;
        this.mIcon = str2;
        this.mName = str3;
        this.evN = str4;
        this.edh = str5;
        this.ecT = str6;
        this.Zb = str7;
        this.mStatus = i;
    }

    public int bca() {
        return this.evL;
    }

    public void oQ(int i) {
        this.evL = i;
    }

    public String bcb() {
        return this.evM;
    }

    public String bcc() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bcd() {
        return this.evN;
    }

    public String bce() {
        return this.edh;
    }

    public String bcf() {
        return this.ecT;
    }
}
