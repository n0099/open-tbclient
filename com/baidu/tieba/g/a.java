package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cOX;
    private String cOY;
    private String cOZ;
    private String cPa;
    private String cPb;
    private String cPc;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cOX = String.valueOf(esportRank.rank);
            this.cOY = esportRank.text;
            this.cPc = esportRank.url;
            if (esportRank.user != null) {
                this.cOZ = esportRank.user.steam_name;
                this.cPa = esportRank.user.steam_portrait;
            }
        }
    }

    public String anr() {
        return this.mTitle;
    }

    public String ans() {
        return this.cOX;
    }

    public String ant() {
        return this.cOY;
    }

    public String anu() {
        return this.cOZ;
    }

    public String anv() {
        return this.cPa;
    }

    public String anw() {
        return this.cPb;
    }

    public void ld(String str) {
        this.cPb = str;
    }

    public String anx() {
        return this.cPc;
    }

    public void le(String str) {
        this.cPc = str;
    }
}
