package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bsN;
    private String dUA;
    private String dUB;
    private String dUC;
    private String dUD;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dUA = String.valueOf(esportRank.rank);
            this.dUB = esportRank.text;
            this.bsN = esportRank.url;
            if (esportRank.user != null) {
                this.dUC = esportRank.user.steam_name;
                this.dUD = esportRank.user.steam_portrait;
            }
        }
    }

    public String aEk() {
        return this.mTitle;
    }

    public String aEl() {
        return this.dUA;
    }

    public String aEm() {
        return this.dUB;
    }

    public String aEn() {
        return this.dUC;
    }

    public String aEo() {
        return this.dUD;
    }

    public String aEp() {
        return this.mImgUrl;
    }

    public void nQ(String str) {
        this.mImgUrl = str;
    }

    public String aEq() {
        return this.bsN;
    }

    public void nR(String str) {
        this.bsN = str;
    }
}
