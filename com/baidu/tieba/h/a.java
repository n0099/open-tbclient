package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cVl;
    private String fRp;
    private String fRq;
    private String fRr;
    private String fRs;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fRp = String.valueOf(esportRank.rank);
            this.fRq = esportRank.text;
            this.cVl = esportRank.url;
            if (esportRank.user != null) {
                this.fRr = esportRank.user.steam_name;
                this.fRs = esportRank.user.steam_portrait;
            }
        }
    }

    public String brB() {
        return this.mTitle;
    }

    public String brC() {
        return this.fRp;
    }

    public String brD() {
        return this.fRq;
    }

    public String brE() {
        return this.fRr;
    }

    public String brF() {
        return this.fRs;
    }

    public String brG() {
        return this.mImgUrl;
    }

    public void xg(String str) {
        this.mImgUrl = str;
    }

    public String brH() {
        return this.cVl;
    }

    public void xh(String str) {
        this.cVl = str;
    }
}
