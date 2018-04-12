package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bcG;
    private String duR;
    private String duS;
    private String duT;
    private String duU;
    private String duV;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.duR = String.valueOf(esportRank.rank);
            this.duS = esportRank.text;
            this.bcG = esportRank.url;
            if (esportRank.user != null) {
                this.duT = esportRank.user.steam_name;
                this.duU = esportRank.user.steam_portrait;
            }
        }
    }

    public String avU() {
        return this.mTitle;
    }

    public String avV() {
        return this.duR;
    }

    public String avW() {
        return this.duS;
    }

    public String avX() {
        return this.duT;
    }

    public String avY() {
        return this.duU;
    }

    public String avZ() {
        return this.duV;
    }

    public void mw(String str) {
        this.duV = str;
    }

    public String awa() {
        return this.bcG;
    }

    public void mx(String str) {
        this.bcG = str;
    }
}
