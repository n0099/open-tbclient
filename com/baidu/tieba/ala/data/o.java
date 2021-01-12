package com.baidu.tieba.ala.data;
/* loaded from: classes10.dex */
public class o {
    private String aKn;
    private int gQj;
    private String gQk;
    private String gQl;
    private String glX;
    private String gms;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gQk = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gQl = str4;
        this.gms = str5;
        this.glX = str6;
        this.aKn = str7;
        this.mStatus = i;
    }

    public int bTL() {
        return this.gQj;
    }

    public void ul(int i) {
        this.gQj = i;
    }

    public String bTM() {
        return this.gQk;
    }

    public String bTN() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bTO() {
        return this.gQl;
    }

    public String bTP() {
        return this.gms;
    }

    public String bTQ() {
        return this.glX;
    }
}
