package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cVm;
    private String fRq;
    private String fRr;
    private String fRs;
    private String fRt;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fRq = String.valueOf(esportRank.rank);
            this.fRr = esportRank.text;
            this.cVm = esportRank.url;
            if (esportRank.user != null) {
                this.fRs = esportRank.user.steam_name;
                this.fRt = esportRank.user.steam_portrait;
            }
        }
    }

    public String brE() {
        return this.mTitle;
    }

    public String brF() {
        return this.fRq;
    }

    public String brG() {
        return this.fRr;
    }

    public String brH() {
        return this.fRs;
    }

    public String brI() {
        return this.fRt;
    }

    public String brJ() {
        return this.mImgUrl;
    }

    public void xg(String str) {
        this.mImgUrl = str;
    }

    public String brK() {
        return this.cVm;
    }

    public void xh(String str) {
        this.cVm = str;
    }
}
