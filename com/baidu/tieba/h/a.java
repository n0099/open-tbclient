package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bmW;
    private String dNm;
    private String dNn;
    private String dNo;
    private String dNp;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dNm = String.valueOf(esportRank.rank);
            this.dNn = esportRank.text;
            this.bmW = esportRank.url;
            if (esportRank.user != null) {
                this.dNo = esportRank.user.steam_name;
                this.dNp = esportRank.user.steam_portrait;
            }
        }
    }

    public String aCa() {
        return this.mTitle;
    }

    public String aCb() {
        return this.dNm;
    }

    public String aCc() {
        return this.dNn;
    }

    public String aCd() {
        return this.dNo;
    }

    public String aCe() {
        return this.dNp;
    }

    public String aCf() {
        return this.mImgUrl;
    }

    public void nj(String str) {
        this.mImgUrl = str;
    }

    public String aCg() {
        return this.bmW;
    }

    public void nk(String str) {
        this.bmW = str;
    }
}
