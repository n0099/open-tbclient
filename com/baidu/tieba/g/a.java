package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String die;
    private String dif;
    private String dig;
    private String dih;
    private String dii;
    private String dij;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.die = String.valueOf(esportRank.rank);
            this.dif = esportRank.text;
            this.dij = esportRank.url;
            if (esportRank.user != null) {
                this.dig = esportRank.user.steam_name;
                this.dih = esportRank.user.steam_portrait;
            }
        }
    }

    public String asq() {
        return this.mTitle;
    }

    public String asr() {
        return this.die;
    }

    public String ass() {
        return this.dif;
    }

    public String ast() {
        return this.dig;
    }

    public String asu() {
        return this.dih;
    }

    public String asv() {
        return this.dii;
    }

    public void lO(String str) {
        this.dii = str;
    }

    public String asw() {
        return this.dij;
    }

    public void lP(String str) {
        this.dij = str;
    }
}
