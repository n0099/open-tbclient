package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aMb;
    private String bmW;
    private String eXQ;
    private String igD;
    private String igE;
    private String igF;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.igD = String.valueOf(esportRank.rank);
            this.aMb = esportRank.text;
            this.eXQ = esportRank.url;
            if (esportRank.user != null) {
                this.igE = esportRank.user.steam_name;
                this.igF = esportRank.user.steam_portrait;
            }
        }
    }

    public String cgK() {
        return this.mTitle;
    }

    public String cgL() {
        return this.igD;
    }

    public String cgM() {
        return this.aMb;
    }

    public String cgN() {
        return this.igE;
    }

    public String cgO() {
        return this.igF;
    }

    public String cgP() {
        return this.bmW;
    }

    public void FP(String str) {
        this.bmW = str;
    }

    public String cgQ() {
        return this.eXQ;
    }

    public void FQ(String str) {
        this.eXQ = str;
    }
}
