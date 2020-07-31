package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aNw;
    private String bnr;
    private String fcs;
    private String imH;
    private String imI;
    private String imJ;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.imH = String.valueOf(esportRank.rank);
            this.aNw = esportRank.text;
            this.fcs = esportRank.url;
            if (esportRank.user != null) {
                this.imI = esportRank.user.steam_name;
                this.imJ = esportRank.user.steam_portrait;
            }
        }
    }

    public String ckk() {
        return this.mTitle;
    }

    public String ckl() {
        return this.imH;
    }

    public String ckm() {
        return this.aNw;
    }

    public String ckn() {
        return this.imI;
    }

    public String cko() {
        return this.imJ;
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
