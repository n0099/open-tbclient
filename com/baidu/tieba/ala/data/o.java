package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class o {
    private String aNj;
    private String fYH;
    private String fYm;
    private int gAw;
    private String gAx;
    private String gAy;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gAx = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gAy = str4;
        this.fYH = str5;
        this.fYm = str6;
        this.aNj = str7;
        this.mStatus = i;
    }

    public int bRT() {
        return this.gAw;
    }

    public void uB(int i) {
        this.gAw = i;
    }

    public String bRU() {
        return this.gAx;
    }

    public String bRV() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bRW() {
        return this.gAy;
    }

    public String bRX() {
        return this.fYH;
    }

    public String bRY() {
        return this.fYm;
    }
}
