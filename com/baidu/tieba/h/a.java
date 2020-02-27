package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aEq;
    private String alq;
    private String dYo;
    private String gRt;
    private String gRu;
    private String gRv;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.gRt = String.valueOf(esportRank.rank);
            this.alq = esportRank.text;
            this.dYo = esportRank.url;
            if (esportRank.user != null) {
                this.gRu = esportRank.user.steam_name;
                this.gRv = esportRank.user.steam_portrait;
            }
        }
    }

    public String bLQ() {
        return this.mTitle;
    }

    public String bLR() {
        return this.gRt;
    }

    public String bLS() {
        return this.alq;
    }

    public String bLT() {
        return this.gRu;
    }

    public String bLU() {
        return this.gRv;
    }

    public String bLV() {
        return this.aEq;
    }

    public void BU(String str) {
        this.aEq = str;
    }

    public String bLW() {
        return this.dYo;
    }

    public void BV(String str) {
        this.dYo = str;
    }
}
