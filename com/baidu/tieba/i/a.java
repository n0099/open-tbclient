package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bTV;
    private String bep;
    private String giS;
    private String jRc;
    private String jRd;
    private String jRe;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jRc = String.valueOf(esportRank.rank);
            this.bep = esportRank.text;
            this.giS = esportRank.url;
            if (esportRank.user != null) {
                this.jRd = esportRank.user.steam_name;
                this.jRe = esportRank.user.steam_portrait;
            }
        }
    }

    public String cJK() {
        return this.mTitle;
    }

    public String cPv() {
        return this.jRc;
    }

    public String cPw() {
        return this.bep;
    }

    public String cPx() {
        return this.jRd;
    }

    public String cPy() {
        return this.jRe;
    }

    public String cPz() {
        return this.bTV;
    }

    public void LO(String str) {
        this.bTV = str;
    }

    public String cPA() {
        return this.giS;
    }

    public void LP(String str) {
        this.giS = str;
    }
}
