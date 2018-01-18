package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String dVA;
    private String dVB;
    private String dVC;
    private String dVD;
    private String dVE;
    private String dVz;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dVz = String.valueOf(esportRank.rank);
            this.dVA = esportRank.text;
            this.dVE = esportRank.url;
            if (esportRank.user != null) {
                this.dVB = esportRank.user.steam_name;
                this.dVC = esportRank.user.steam_portrait;
            }
        }
    }

    public String azz() {
        return this.mTitle;
    }

    public String azA() {
        return this.dVz;
    }

    public String azB() {
        return this.dVA;
    }

    public String azC() {
        return this.dVB;
    }

    public String azD() {
        return this.dVC;
    }

    public String azE() {
        return this.dVD;
    }

    public void mc(String str) {
        this.dVD = str;
    }

    public String azF() {
        return this.dVE;
    }

    public void md(String str) {
        this.dVE = str;
    }
}
