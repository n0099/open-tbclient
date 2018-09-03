package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bmZ;
    private String dNi;
    private String dNj;
    private String dNk;
    private String dNl;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dNi = String.valueOf(esportRank.rank);
            this.dNj = esportRank.text;
            this.bmZ = esportRank.url;
            if (esportRank.user != null) {
                this.dNk = esportRank.user.steam_name;
                this.dNl = esportRank.user.steam_portrait;
            }
        }
    }

    public String aBX() {
        return this.mTitle;
    }

    public String aBY() {
        return this.dNi;
    }

    public String aBZ() {
        return this.dNj;
    }

    public String aCa() {
        return this.dNk;
    }

    public String aCb() {
        return this.dNl;
    }

    public String aCc() {
        return this.mImgUrl;
    }

    public void nl(String str) {
        this.mImgUrl = str;
    }

    public String aCd() {
        return this.bmZ;
    }

    public void nm(String str) {
        this.bmZ = str;
    }
}
