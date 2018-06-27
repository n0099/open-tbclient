package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bmq;
    private String dKA;
    private String dKB;
    private String dKC;
    private String dKz;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dKz = String.valueOf(esportRank.rank);
            this.dKA = esportRank.text;
            this.bmq = esportRank.url;
            if (esportRank.user != null) {
                this.dKB = esportRank.user.steam_name;
                this.dKC = esportRank.user.steam_portrait;
            }
        }
    }

    public String aBr() {
        return this.mTitle;
    }

    public String aBs() {
        return this.dKz;
    }

    public String aBt() {
        return this.dKA;
    }

    public String aBu() {
        return this.dKB;
    }

    public String aBv() {
        return this.dKC;
    }

    public String aBw() {
        return this.mImgUrl;
    }

    public void nl(String str) {
        this.mImgUrl = str;
    }

    public String aBx() {
        return this.bmq;
    }

    public void nm(String str) {
        this.bmq = str;
    }
}
