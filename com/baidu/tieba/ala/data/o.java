package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class o {
    private String aOt;
    private int gJa;
    private String gJb;
    private String gJc;
    private String gge;
    private String ggz;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gJb = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gJc = str4;
        this.ggz = str5;
        this.gge = str6;
        this.aOt = str7;
        this.mStatus = i;
    }

    public int bUW() {
        return this.gJa;
    }

    public void vG(int i) {
        this.gJa = i;
    }

    public String bUX() {
        return this.gJb;
    }

    public String bUY() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bUZ() {
        return this.gJc;
    }

    public String bVa() {
        return this.ggz;
    }

    public String bVb() {
        return this.gge;
    }
}
