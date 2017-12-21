package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String dii;
    private String dij;
    private String dik;
    private String dil;
    private String dim;
    private String din;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dii = String.valueOf(esportRank.rank);
            this.dij = esportRank.text;
            this.din = esportRank.url;
            if (esportRank.user != null) {
                this.dik = esportRank.user.steam_name;
                this.dil = esportRank.user.steam_portrait;
            }
        }
    }

    public String asr() {
        return this.mTitle;
    }

    public String ass() {
        return this.dii;
    }

    public String ast() {
        return this.dij;
    }

    public String asu() {
        return this.dik;
    }

    public String asv() {
        return this.dil;
    }

    public String asw() {
        return this.dim;
    }

    public void lO(String str) {
        this.dim = str;
    }

    public String asx() {
        return this.din;
    }

    public void lP(String str) {
        this.din = str;
    }
}
