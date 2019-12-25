package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String azq;
    private String dUb;
    private String gLY;
    private String gLZ;
    private String gMa;
    private String gMb;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.gLY = String.valueOf(esportRank.rank);
            this.gLZ = esportRank.text;
            this.dUb = esportRank.url;
            if (esportRank.user != null) {
                this.gMa = esportRank.user.steam_name;
                this.gMb = esportRank.user.steam_portrait;
            }
        }
    }

    public String bJj() {
        return this.mTitle;
    }

    public String bJk() {
        return this.gLY;
    }

    public String bJl() {
        return this.gLZ;
    }

    public String bJm() {
        return this.gMa;
    }

    public String bJn() {
        return this.gMb;
    }

    public String bJo() {
        return this.azq;
    }

    public void Bu(String str) {
        this.azq = str;
    }

    public String bJp() {
        return this.dUb;
    }

    public void Bv(String str) {
        this.dUb = str;
    }
}
