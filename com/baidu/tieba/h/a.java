package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String arY;
    private String dhg;
    private String fYr;
    private String fYs;
    private String fYt;
    private String fYu;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fYr = String.valueOf(esportRank.rank);
            this.fYs = esportRank.text;
            this.dhg = esportRank.url;
            if (esportRank.user != null) {
                this.fYt = esportRank.user.steam_name;
                this.fYu = esportRank.user.steam_portrait;
            }
        }
    }

    public String brK() {
        return this.mTitle;
    }

    public String brL() {
        return this.fYr;
    }

    public String brM() {
        return this.fYs;
    }

    public String brN() {
        return this.fYt;
    }

    public String brO() {
        return this.fYu;
    }

    public String brP() {
        return this.arY;
    }

    public void wF(String str) {
        this.arY = str;
    }

    public String brQ() {
        return this.dhg;
    }

    public void wG(String str) {
        this.dhg = str;
    }
}
