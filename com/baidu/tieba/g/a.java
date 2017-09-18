package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cNX;
    private String cNY;
    private String cNZ;
    private String cOa;
    private String cOb;
    private String cOc;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cNX = String.valueOf(esportRank.rank);
            this.cNY = esportRank.text;
            this.cOc = esportRank.url;
            if (esportRank.user != null) {
                this.cNZ = esportRank.user.steam_name;
                this.cOa = esportRank.user.steam_portrait;
            }
        }
    }

    public String ann() {
        return this.mTitle;
    }

    public String ano() {
        return this.cNX;
    }

    public String anp() {
        return this.cNY;
    }

    public String anq() {
        return this.cNZ;
    }

    public String anr() {
        return this.cOa;
    }

    public String ans() {
        return this.cOb;
    }

    public void lg(String str) {
        this.cOb = str;
    }

    public String ant() {
        return this.cOc;
    }

    public void lh(String str) {
        this.cOc = str;
    }
}
