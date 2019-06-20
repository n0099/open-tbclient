package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cVn;
    private String fRs;
    private String fRt;
    private String fRu;
    private String fRv;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fRs = String.valueOf(esportRank.rank);
            this.fRt = esportRank.text;
            this.cVn = esportRank.url;
            if (esportRank.user != null) {
                this.fRu = esportRank.user.steam_name;
                this.fRv = esportRank.user.steam_portrait;
            }
        }
    }

    public String brG() {
        return this.mTitle;
    }

    public String brH() {
        return this.fRs;
    }

    public String brI() {
        return this.fRt;
    }

    public String brJ() {
        return this.fRu;
    }

    public String brK() {
        return this.fRv;
    }

    public String brL() {
        return this.mImgUrl;
    }

    public void xi(String str) {
        this.mImgUrl = str;
    }

    public String brM() {
        return this.cVn;
    }

    public void xj(String str) {
        this.cVn = str;
    }
}
