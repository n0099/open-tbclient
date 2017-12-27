package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String dUq;
    private String dUr;
    private String dUs;
    private String dUt;
    private String dUu;
    private String dUv;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dUq = String.valueOf(esportRank.rank);
            this.dUr = esportRank.text;
            this.dUv = esportRank.url;
            if (esportRank.user != null) {
                this.dUs = esportRank.user.steam_name;
                this.dUt = esportRank.user.steam_portrait;
            }
        }
    }

    public String azx() {
        return this.mTitle;
    }

    public String azy() {
        return this.dUq;
    }

    public String azz() {
        return this.dUr;
    }

    public String azA() {
        return this.dUs;
    }

    public String azB() {
        return this.dUt;
    }

    public String azC() {
        return this.dUu;
    }

    public void lX(String str) {
        this.dUu = str;
    }

    public String azD() {
        return this.dUv;
    }

    public void lY(String str) {
        this.dUv = str;
    }
}
