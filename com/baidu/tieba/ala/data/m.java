package com.baidu.tieba.ala.data;
/* loaded from: classes4.dex */
public class m {
    private String aIB;
    private int fYj;
    private String fYk;
    private String fYl;
    private String fxT;
    private String fyr;
    private String mIcon;
    private String mName;
    public int mStatus;

    public m() {
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.fYk = str;
        this.mIcon = str2;
        this.mName = str3;
        this.fYl = str4;
        this.fyr = str5;
        this.fxT = str6;
        this.aIB = str7;
        this.mStatus = i;
    }

    public int bKe() {
        return this.fYj;
    }

    public void tB(int i) {
        this.fYj = i;
    }

    public String bKf() {
        return this.fYk;
    }

    public String bKg() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bKh() {
        return this.fYl;
    }

    public String bKi() {
        return this.fyr;
    }

    public String bKj() {
        return this.fxT;
    }
}
