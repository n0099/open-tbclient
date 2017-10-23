package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cOL;
    private String cOM;
    private String cON;
    private String cOO;
    private String cOP;
    private String cOQ;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cOL = String.valueOf(esportRank.rank);
            this.cOM = esportRank.text;
            this.cOQ = esportRank.url;
            if (esportRank.user != null) {
                this.cON = esportRank.user.steam_name;
                this.cOO = esportRank.user.steam_portrait;
            }
        }
    }

    public String anm() {
        return this.mTitle;
    }

    public String ann() {
        return this.cOL;
    }

    public String ano() {
        return this.cOM;
    }

    public String anp() {
        return this.cON;
    }

    public String anq() {
        return this.cOO;
    }

    public String anr() {
        return this.cOP;
    }

    public void lc(String str) {
        this.cOP = str;
    }

    public String ans() {
        return this.cOQ;
    }

    public void ld(String str) {
        this.cOQ = str;
    }
}
