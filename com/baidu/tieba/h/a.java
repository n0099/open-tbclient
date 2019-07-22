package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cWJ;
    private String fWp;
    private String fWq;
    private String fWr;
    private String fWs;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fWp = String.valueOf(esportRank.rank);
            this.fWq = esportRank.text;
            this.cWJ = esportRank.url;
            if (esportRank.user != null) {
                this.fWr = esportRank.user.steam_name;
                this.fWs = esportRank.user.steam_portrait;
            }
        }
    }

    public String btH() {
        return this.mTitle;
    }

    public String btI() {
        return this.fWp;
    }

    public String btJ() {
        return this.fWq;
    }

    public String btK() {
        return this.fWr;
    }

    public String btL() {
        return this.fWs;
    }

    public String btM() {
        return this.mImgUrl;
    }

    public void xN(String str) {
        this.mImgUrl = str;
    }

    public String btN() {
        return this.cWJ;
    }

    public void xO(String str) {
        this.cWJ = str;
    }
}
