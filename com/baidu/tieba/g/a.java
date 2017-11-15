package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cYq;
    private String cYr;
    private String cYs;
    private String cYt;
    private String cYu;
    private String cYv;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cYq = String.valueOf(esportRank.rank);
            this.cYr = esportRank.text;
            this.cYv = esportRank.url;
            if (esportRank.user != null) {
                this.cYs = esportRank.user.steam_name;
                this.cYt = esportRank.user.steam_portrait;
            }
        }
    }

    public String aqn() {
        return this.mTitle;
    }

    public String aqo() {
        return this.cYq;
    }

    public String aqp() {
        return this.cYr;
    }

    public String aqq() {
        return this.cYs;
    }

    public String aqr() {
        return this.cYt;
    }

    public String aqs() {
        return this.cYu;
    }

    public void lF(String str) {
        this.cYu = str;
    }

    public String aqt() {
        return this.cYv;
    }

    public void lG(String str) {
        this.cYv = str;
    }
}
