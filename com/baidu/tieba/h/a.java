package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aAa;
    private String aji;
    private String dUk;
    private String gPt;
    private String gPu;
    private String gPv;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.gPt = String.valueOf(esportRank.rank);
            this.aji = esportRank.text;
            this.dUk = esportRank.url;
            if (esportRank.user != null) {
                this.gPu = esportRank.user.steam_name;
                this.gPv = esportRank.user.steam_portrait;
            }
        }
    }

    public String bKo() {
        return this.mTitle;
    }

    public String bKp() {
        return this.gPt;
    }

    public String bKq() {
        return this.aji;
    }

    public String bKr() {
        return this.gPu;
    }

    public String bKs() {
        return this.gPv;
    }

    public String bKt() {
        return this.aAa;
    }

    public void BE(String str) {
        this.aAa = str;
    }

    public String bKu() {
        return this.dUk;
    }

    public void BF(String str) {
        this.dUk = str;
    }
}
