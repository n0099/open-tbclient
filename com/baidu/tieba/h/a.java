package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cNa;
    private String fAs;
    private String fAt;
    private String fAu;
    private String fAv;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fAs = String.valueOf(esportRank.rank);
            this.fAt = esportRank.text;
            this.cNa = esportRank.url;
            if (esportRank.user != null) {
                this.fAu = esportRank.user.steam_name;
                this.fAv = esportRank.user.steam_portrait;
            }
        }
    }

    public String bkj() {
        return this.mTitle;
    }

    public String bkk() {
        return this.fAs;
    }

    public String bkl() {
        return this.fAt;
    }

    public String bkm() {
        return this.fAu;
    }

    public String bkn() {
        return this.fAv;
    }

    public String bko() {
        return this.mImgUrl;
    }

    public void vR(String str) {
        this.mImgUrl = str;
    }

    public String bkp() {
        return this.cNa;
    }

    public void vS(String str) {
        this.cNa = str;
    }
}
