package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String dgZ;
    private String dha;
    private String dhb;
    private String dhc;
    private String dhd;
    private String dhe;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dgZ = String.valueOf(esportRank.rank);
            this.dha = esportRank.text;
            this.dhe = esportRank.url;
            if (esportRank.user != null) {
                this.dhb = esportRank.user.steam_name;
                this.dhc = esportRank.user.steam_portrait;
            }
        }
    }

    public String ash() {
        return this.mTitle;
    }

    public String asi() {
        return this.dgZ;
    }

    public String asj() {
        return this.dha;
    }

    public String ask() {
        return this.dhb;
    }

    public String asl() {
        return this.dhc;
    }

    public String asm() {
        return this.dhd;
    }

    public void lO(String str) {
        this.dhd = str;
    }

    public String asn() {
        return this.dhe;
    }

    public void lP(String str) {
        this.dhe = str;
    }
}
