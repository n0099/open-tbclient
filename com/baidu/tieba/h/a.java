package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bBf;
    private String enA;
    private String enx;
    private String eny;
    private String enz;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.enx = String.valueOf(esportRank.rank);
            this.eny = esportRank.text;
            this.bBf = esportRank.url;
            if (esportRank.user != null) {
                this.enz = esportRank.user.steam_name;
                this.enA = esportRank.user.steam_portrait;
            }
        }
    }

    public String aJG() {
        return this.mTitle;
    }

    public String aJH() {
        return this.enx;
    }

    public String aJI() {
        return this.eny;
    }

    public String aJJ() {
        return this.enz;
    }

    public String aJK() {
        return this.enA;
    }

    public String aJL() {
        return this.mImgUrl;
    }

    public void pa(String str) {
        this.mImgUrl = str;
    }

    public String aJM() {
        return this.bBf;
    }

    public void pb(String str) {
        this.bBf = str;
    }
}
