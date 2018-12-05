package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bBc;
    private String ekG;
    private String ekH;
    private String ekI;
    private String ekJ;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.ekG = String.valueOf(esportRank.rank);
            this.ekH = esportRank.text;
            this.bBc = esportRank.url;
            if (esportRank.user != null) {
                this.ekI = esportRank.user.steam_name;
                this.ekJ = esportRank.user.steam_portrait;
            }
        }
    }

    public String aIR() {
        return this.mTitle;
    }

    public String aIS() {
        return this.ekG;
    }

    public String aIT() {
        return this.ekH;
    }

    public String aIU() {
        return this.ekI;
    }

    public String aIV() {
        return this.ekJ;
    }

    public String aIW() {
        return this.mImgUrl;
    }

    public void oX(String str) {
        this.mImgUrl = str;
    }

    public String aIX() {
        return this.bBc;
    }

    public void oY(String str) {
        this.bBc = str;
    }
}
