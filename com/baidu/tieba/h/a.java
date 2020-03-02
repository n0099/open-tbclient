package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aEr;
    private String alq;
    private String dYp;
    private String gRv;
    private String gRw;
    private String gRx;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.gRv = String.valueOf(esportRank.rank);
            this.alq = esportRank.text;
            this.dYp = esportRank.url;
            if (esportRank.user != null) {
                this.gRw = esportRank.user.steam_name;
                this.gRx = esportRank.user.steam_portrait;
            }
        }
    }

    public String bLS() {
        return this.mTitle;
    }

    public String bLT() {
        return this.gRv;
    }

    public String bLU() {
        return this.alq;
    }

    public String bLV() {
        return this.gRw;
    }

    public String bLW() {
        return this.gRx;
    }

    public String bLX() {
        return this.aEr;
    }

    public void BU(String str) {
        this.aEr = str;
    }

    public String bLY() {
        return this.dYp;
    }

    public void BV(String str) {
        this.dYp = str;
    }
}
