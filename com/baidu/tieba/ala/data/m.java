package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class m {
    private String aLF;
    private String fKA;
    private String fKc;
    private int gkB;
    private String gkC;
    private String gkD;
    private String mIcon;
    private String mName;
    public int mStatus;

    public m() {
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gkC = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gkD = str4;
        this.fKA = str5;
        this.fKc = str6;
        this.aLF = str7;
        this.mStatus = i;
    }

    public int bMO() {
        return this.gkB;
    }

    public void tZ(int i) {
        this.gkB = i;
    }

    public String bMP() {
        return this.gkC;
    }

    public String bMQ() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bMR() {
        return this.gkD;
    }

    public String bMS() {
        return this.fKA;
    }

    public String bMT() {
        return this.fKc;
    }
}
