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

    public String cJL() {
        return this.mTitle;
    }

    public String cPw() {
        return this.jRc;
    }

    public String cPx() {
        return this.bep;
    }

    public String cPy() {
        return this.jRd;
    }

    public String cPz() {
        return this.jRe;
    }

    public String cPA() {
        return this.bTV;
    }

    public void LN(String str) {
        this.bTV = str;
    }

    public String cPB() {
        return this.giS;
    }

    public void LO(String str) {
        this.giS = str;
    }
}
