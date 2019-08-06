package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cWQ;
    private String fXf;
    private String fXg;
    private String fXh;
    private String fXi;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fXf = String.valueOf(esportRank.rank);
            this.fXg = esportRank.text;
            this.cWQ = esportRank.url;
            if (esportRank.user != null) {
                this.fXh = esportRank.user.steam_name;
                this.fXi = esportRank.user.steam_portrait;
            }
        }
    }

    public String btU() {
        return this.mTitle;
    }

    public String btV() {
        return this.fXf;
    }

    public String btW() {
        return this.fXg;
    }

    public String btX() {
        return this.fXh;
    }

    public String btY() {
        return this.fXi;
    }

    public String btZ() {
        return this.mImgUrl;
    }

    public void xO(String str) {
        this.mImgUrl = str;
    }

    public String bua() {
        return this.cWQ;
    }

    public void xP(String str) {
        this.cWQ = str;
    }
}
