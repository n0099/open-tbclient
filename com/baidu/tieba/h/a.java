package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bBT;
    private String eoe;
    private String eog;
    private String eoh;
    private String eoi;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.eoe = String.valueOf(esportRank.rank);
            this.eog = esportRank.text;
            this.bBT = esportRank.url;
            if (esportRank.user != null) {
                this.eoh = esportRank.user.steam_name;
                this.eoi = esportRank.user.steam_portrait;
            }
        }
    }

    public String aKe() {
        return this.mTitle;
    }

    public String aKf() {
        return this.eoe;
    }

    public String aKg() {
        return this.eog;
    }

    public String aKh() {
        return this.eoh;
    }

    public String aKi() {
        return this.eoi;
    }

    public String aKj() {
        return this.mImgUrl;
    }

    public void pq(String str) {
        this.mImgUrl = str;
    }

    public String aKk() {
        return this.bBT;
    }

    public void pr(String str) {
        this.bBT = str;
    }
}
