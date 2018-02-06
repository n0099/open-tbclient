package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bSL;
    private String eah;
    private String eai;
    private String eaj;
    private String eak;
    private String eal;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.eah = String.valueOf(esportRank.rank);
            this.eai = esportRank.text;
            this.bSL = esportRank.url;
            if (esportRank.user != null) {
                this.eaj = esportRank.user.steam_name;
                this.eak = esportRank.user.steam_portrait;
            }
        }
    }

    public String aAY() {
        return this.mTitle;
    }

    public String aAZ() {
        return this.eah;
    }

    public String aBa() {
        return this.eai;
    }

    public String aBb() {
        return this.eaj;
    }

    public String aBc() {
        return this.eak;
    }

    public String aBd() {
        return this.eal;
    }

    public void mt(String str) {
        this.eal = str;
    }

    public String aBe() {
        return this.bSL;
    }

    public void mu(String str) {
        this.bSL = str;
    }
}
