package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cNa;
    private String fAF;
    private String fAG;
    private String fAH;
    private String fAI;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fAF = String.valueOf(esportRank.rank);
            this.fAG = esportRank.text;
            this.cNa = esportRank.url;
            if (esportRank.user != null) {
                this.fAH = esportRank.user.steam_name;
                this.fAI = esportRank.user.steam_portrait;
            }
        }
    }

    public String bkl() {
        return this.mTitle;
    }

    public String bkm() {
        return this.fAF;
    }

    public String bkn() {
        return this.fAG;
    }

    public String bko() {
        return this.fAH;
    }

    public String bkp() {
        return this.fAI;
    }

    public String bkq() {
        return this.mImgUrl;
    }

    public void vT(String str) {
        this.mImgUrl = str;
    }

    public String bkr() {
        return this.cNa;
    }

    public void vU(String str) {
        this.cNa = str;
    }
}
