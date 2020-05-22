package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aJv;
    private String bhP;
    private String eNu;
    private String hRw;
    private String hRx;
    private String hRy;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.hRw = String.valueOf(esportRank.rank);
            this.aJv = esportRank.text;
            this.eNu = esportRank.url;
            if (esportRank.user != null) {
                this.hRx = esportRank.user.steam_name;
                this.hRy = esportRank.user.steam_portrait;
            }
        }
    }

    public String cdf() {
        return this.mTitle;
    }

    public String cdg() {
        return this.hRw;
    }

    public String cdh() {
        return this.aJv;
    }

    public String cdi() {
        return this.hRx;
    }

    public String cdj() {
        return this.hRy;
    }

    public String cdk() {
        return this.bhP;
    }

    public void Fp(String str) {
        this.bhP = str;
    }

    public String cdl() {
        return this.eNu;
    }

    public void Fq(String str) {
        this.eNu = str;
    }
}
