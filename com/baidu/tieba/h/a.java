package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cMX;
    private String fAE;
    private String fAF;
    private String fAG;
    private String fAH;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fAE = String.valueOf(esportRank.rank);
            this.fAF = esportRank.text;
            this.cMX = esportRank.url;
            if (esportRank.user != null) {
                this.fAG = esportRank.user.steam_name;
                this.fAH = esportRank.user.steam_portrait;
            }
        }
    }

    public String bkl() {
        return this.mTitle;
    }

    public String bkm() {
        return this.fAE;
    }

    public String bkn() {
        return this.fAF;
    }

    public String bko() {
        return this.fAG;
    }

    public String bkp() {
        return this.fAH;
    }

    public String bkq() {
        return this.mImgUrl;
    }

    public void vS(String str) {
        this.mImgUrl = str;
    }

    public String bkr() {
        return this.cMX;
    }

    public void vT(String str) {
        this.cMX = str;
    }
}
