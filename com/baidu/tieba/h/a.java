package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bcG;
    private String duO;
    private String duP;
    private String duQ;
    private String duR;
    private String duS;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.duO = String.valueOf(esportRank.rank);
            this.duP = esportRank.text;
            this.bcG = esportRank.url;
            if (esportRank.user != null) {
                this.duQ = esportRank.user.steam_name;
                this.duR = esportRank.user.steam_portrait;
            }
        }
    }

    public String avU() {
        return this.mTitle;
    }

    public String avV() {
        return this.duO;
    }

    public String avW() {
        return this.duP;
    }

    public String avX() {
        return this.duQ;
    }

    public String avY() {
        return this.duR;
    }

    public String avZ() {
        return this.duS;
    }

    public void mw(String str) {
        this.duS = str;
    }

    public String awa() {
        return this.bcG;
    }

    public void mx(String str) {
        this.bcG = str;
    }
}
