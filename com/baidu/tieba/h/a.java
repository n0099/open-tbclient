package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bxF;
    private String edO;
    private String edP;
    private String edQ;
    private String edR;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.edO = String.valueOf(esportRank.rank);
            this.edP = esportRank.text;
            this.bxF = esportRank.url;
            if (esportRank.user != null) {
                this.edQ = esportRank.user.steam_name;
                this.edR = esportRank.user.steam_portrait;
            }
        }
    }

    public String aHa() {
        return this.mTitle;
    }

    public String aHb() {
        return this.edO;
    }

    public String aHc() {
        return this.edP;
    }

    public String aHd() {
        return this.edQ;
    }

    public String aHe() {
        return this.edR;
    }

    public String aHf() {
        return this.mImgUrl;
    }

    public void ov(String str) {
        this.mImgUrl = str;
    }

    public String aHg() {
        return this.bxF;
    }

    public void ow(String str) {
        this.bxF = str;
    }
}
