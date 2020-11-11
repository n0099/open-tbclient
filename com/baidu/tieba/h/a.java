package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bLu;
    private String baV;
    private String fRs;
    private String jpB;
    private String jpC;
    private String jpD;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jpB = String.valueOf(esportRank.rank);
            this.baV = esportRank.text;
            this.fRs = esportRank.url;
            if (esportRank.user != null) {
                this.jpC = esportRank.user.steam_name;
                this.jpD = esportRank.user.steam_portrait;
            }
        }
    }

    public String cHn() {
        return this.mTitle;
    }

    public String cHo() {
        return this.jpB;
    }

    public String cHp() {
        return this.baV;
    }

    public String cHq() {
        return this.jpC;
    }

    public String cHr() {
        return this.jpD;
    }

    public String cHs() {
        return this.bLu;
    }

    public void Lf(String str) {
        this.bLu = str;
    }

    public String cHt() {
        return this.fRs;
    }

    public void Lg(String str) {
        this.fRs = str;
    }
}
