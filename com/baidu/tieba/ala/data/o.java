package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class o {
    private String aOt;
    private int gJc;
    private String gJd;
    private String gJe;
    private String ggB;
    private String ggg;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gJd = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gJe = str4;
        this.ggB = str5;
        this.ggg = str6;
        this.aOt = str7;
        this.mStatus = i;
    }

    public int bUX() {
        return this.gJc;
    }

    public void vG(int i) {
        this.gJc = i;
    }

    public String bUY() {
        return this.gJd;
    }

    public String bUZ() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bVa() {
        return this.gJe;
    }

    public String bVb() {
        return this.ggB;
    }

    public String bVc() {
        return this.ggg;
    }
}
