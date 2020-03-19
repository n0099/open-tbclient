package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aEG;
    private String alB;
    private String dYS;
    private String gSO;
    private String gSP;
    private String gSQ;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.gSO = String.valueOf(esportRank.rank);
            this.alB = esportRank.text;
            this.dYS = esportRank.url;
            if (esportRank.user != null) {
                this.gSP = esportRank.user.steam_name;
                this.gSQ = esportRank.user.steam_portrait;
            }
        }
    }

    public String bMh() {
        return this.mTitle;
    }

    public String bMi() {
        return this.gSO;
    }

    public String bMj() {
        return this.alB;
    }

    public String bMk() {
        return this.gSP;
    }

    public String bMl() {
        return this.gSQ;
    }

    public String bMm() {
        return this.aEG;
    }

    public void BV(String str) {
        this.aEG = str;
    }

    public String bMn() {
        return this.dYS;
    }

    public void BW(String str) {
        this.dYS = str;
    }
}
