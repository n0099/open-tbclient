package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aDQ;
    private String ban;
    private String eyP;
    private String hCD;
    private String hCE;
    private String hCF;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.hCD = String.valueOf(esportRank.rank);
            this.aDQ = esportRank.text;
            this.eyP = esportRank.url;
            if (esportRank.user != null) {
                this.hCE = esportRank.user.steam_name;
                this.hCF = esportRank.user.steam_portrait;
            }
        }
    }

    public String bWI() {
        return this.mTitle;
    }

    public String bWJ() {
        return this.hCD;
    }

    public String bWK() {
        return this.aDQ;
    }

    public String bWL() {
        return this.hCE;
    }

    public String bWM() {
        return this.hCF;
    }

    public String bWN() {
        return this.ban;
    }

    public void DD(String str) {
        this.ban = str;
    }

    public String bWO() {
        return this.eyP;
    }

    public void DE(String str) {
        this.eyP = str;
    }
}
