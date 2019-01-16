package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bBS;
    private String eod;
    private String eoe;
    private String eog;
    private String eoh;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.eod = String.valueOf(esportRank.rank);
            this.eoe = esportRank.text;
            this.bBS = esportRank.url;
            if (esportRank.user != null) {
                this.eog = esportRank.user.steam_name;
                this.eoh = esportRank.user.steam_portrait;
            }
        }
    }

    public String aKe() {
        return this.mTitle;
    }

    public String aKf() {
        return this.eod;
    }

    public String aKg() {
        return this.eoe;
    }

    public String aKh() {
        return this.eog;
    }

    public String aKi() {
        return this.eoh;
    }

    public String aKj() {
        return this.mImgUrl;
    }

    public void pq(String str) {
        this.mImgUrl = str;
    }

    public String aKk() {
        return this.bBS;
    }

    public void pr(String str) {
        this.bBS = str;
    }
}
