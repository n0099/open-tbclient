package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bSC;
    private String eal;
    private String eam;
    private String ean;
    private String eao;
    private String eap;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.eal = String.valueOf(esportRank.rank);
            this.eam = esportRank.text;
            this.bSC = esportRank.url;
            if (esportRank.user != null) {
                this.ean = esportRank.user.steam_name;
                this.eao = esportRank.user.steam_portrait;
            }
        }
    }

    public String aAY() {
        return this.mTitle;
    }

    public String aAZ() {
        return this.eal;
    }

    public String aBa() {
        return this.eam;
    }

    public String aBb() {
        return this.ean;
    }

    public String aBc() {
        return this.eao;
    }

    public String aBd() {
        return this.eap;
    }

    public void mt(String str) {
        this.eap = str;
    }

    public String aBe() {
        return this.bSC;
    }

    public void mu(String str) {
        this.bSC = str;
    }
}
