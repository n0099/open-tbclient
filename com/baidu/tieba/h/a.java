package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aEs;
    private String alr;
    private String dYC;
    private String gRH;
    private String gRI;
    private String gRJ;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.gRH = String.valueOf(esportRank.rank);
            this.alr = esportRank.text;
            this.dYC = esportRank.url;
            if (esportRank.user != null) {
                this.gRI = esportRank.user.steam_name;
                this.gRJ = esportRank.user.steam_portrait;
            }
        }
    }

    public String bLT() {
        return this.mTitle;
    }

    public String bLU() {
        return this.gRH;
    }

    public String bLV() {
        return this.alr;
    }

    public String bLW() {
        return this.gRI;
    }

    public String bLX() {
        return this.gRJ;
    }

    public String bLY() {
        return this.aEs;
    }

    public void BV(String str) {
        this.aEs = str;
    }

    public String bLZ() {
        return this.dYC;
    }

    public void BW(String str) {
        this.dYC = str;
    }
}
