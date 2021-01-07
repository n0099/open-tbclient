package com.baidu.tieba.ala.data;
/* loaded from: classes11.dex */
public class o {
    private String aPa;
    private int gUP;
    private String gUQ;
    private String gUR;
    private String gqE;
    private String gqZ;
    private String mIcon;
    private String mName;
    public int mStatus;

    public o() {
    }

    public o(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i) {
        this.gUQ = str;
        this.mIcon = str2;
        this.mName = str3;
        this.gUR = str4;
        this.gqZ = str5;
        this.gqE = str6;
        this.aPa = str7;
        this.mStatus = i;
    }

    public int bXD() {
        return this.gUP;
    }

    public void vR(int i) {
        this.gUP = i;
    }

    public String bXE() {
        return this.gUQ;
    }

    public String bXF() {
        return this.mIcon;
    }

    public String getmName() {
        return this.mName;
    }

    public String bXG() {
        return this.gUR;
    }

    public String bXH() {
        return this.gqZ;
    }

    public String bXI() {
        return this.gqE;
    }
}
