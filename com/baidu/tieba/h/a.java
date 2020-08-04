package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aNw;
    private String bnr;
    private String fcs;
    private String imJ;
    private String imK;
    private String imL;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.imJ = String.valueOf(esportRank.rank);
            this.aNw = esportRank.text;
            this.fcs = esportRank.url;
            if (esportRank.user != null) {
                this.imK = esportRank.user.steam_name;
                this.imL = esportRank.user.steam_portrait;
            }
        }
    }

    public String ckk() {
        return this.mTitle;
    }

    public String ckl() {
        return this.imJ;
    }

    public String ckm() {
        return this.aNw;
    }

    public String ckn() {
        return this.imK;
    }

    public String cko() {
        return this.imL;
    }

    public String ckp() {
        return this.bnr;
    }

    public void GB(String str) {
        this.bnr = str;
    }

    public String ckq() {
        return this.fcs;
    }

    public void GC(String str) {
        this.fcs = str;
    }
}
