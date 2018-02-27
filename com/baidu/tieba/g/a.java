package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bSz;
    private String dZV;
    private String dZW;
    private String dZX;
    private String dZY;
    private String dZZ;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dZV = String.valueOf(esportRank.rank);
            this.dZW = esportRank.text;
            this.bSz = esportRank.url;
            if (esportRank.user != null) {
                this.dZX = esportRank.user.steam_name;
                this.dZY = esportRank.user.steam_portrait;
            }
        }
    }

    public String aAX() {
        return this.mTitle;
    }

    public String aAY() {
        return this.dZV;
    }

    public String aAZ() {
        return this.dZW;
    }

    public String aBa() {
        return this.dZX;
    }

    public String aBb() {
        return this.dZY;
    }

    public String aBc() {
        return this.dZZ;
    }

    public void mt(String str) {
        this.dZZ = str;
    }

    public String aBd() {
        return this.bSz;
    }

    public void mu(String str) {
        this.bSz = str;
    }
}
