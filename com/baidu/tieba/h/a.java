package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bkR;
    private String dHg;
    private String dHh;
    private String dHi;
    private String dHj;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dHg = String.valueOf(esportRank.rank);
            this.dHh = esportRank.text;
            this.bkR = esportRank.url;
            if (esportRank.user != null) {
                this.dHi = esportRank.user.steam_name;
                this.dHj = esportRank.user.steam_portrait;
            }
        }
    }

    public String aAL() {
        return this.mTitle;
    }

    public String aAM() {
        return this.dHg;
    }

    public String aAN() {
        return this.dHh;
    }

    public String aAO() {
        return this.dHi;
    }

    public String aAP() {
        return this.dHj;
    }

    public String aAQ() {
        return this.mImgUrl;
    }

    public void nk(String str) {
        this.mImgUrl = str;
    }

    public String aAR() {
        return this.bkR;
    }

    public void nl(String str) {
        this.bkR = str;
    }
}
