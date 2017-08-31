package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cNd;
    private String cNe;
    private String cNf;
    private String cNg;
    private String cNh;
    private String cNi;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cNd = String.valueOf(esportRank.rank);
            this.cNe = esportRank.text;
            this.cNi = esportRank.url;
            if (esportRank.user != null) {
                this.cNf = esportRank.user.steam_name;
                this.cNg = esportRank.user.steam_portrait;
            }
        }
    }

    public String anc() {
        return this.mTitle;
    }

    public String and() {
        return this.cNd;
    }

    public String ane() {
        return this.cNe;
    }

    public String anf() {
        return this.cNf;
    }

    public String ang() {
        return this.cNg;
    }

    public String anh() {
        return this.cNh;
    }

    public void le(String str) {
        this.cNh = str;
    }

    public String ani() {
        return this.cNi;
    }

    public void lf(String str) {
        this.cNi = str;
    }
}
