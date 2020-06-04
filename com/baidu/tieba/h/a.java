package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aJv;
    private String bhP;
    private String eNF;
    private String hSj;
    private String hSk;
    private String hSl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.hSj = String.valueOf(esportRank.rank);
            this.aJv = esportRank.text;
            this.eNF = esportRank.url;
            if (esportRank.user != null) {
                this.hSk = esportRank.user.steam_name;
                this.hSl = esportRank.user.steam_portrait;
            }
        }
    }

    public String cdn() {
        return this.mTitle;
    }

    public String cdo() {
        return this.hSj;
    }

    public String cdp() {
        return this.aJv;
    }

    public String cdq() {
        return this.hSk;
    }

    public String cdr() {
        return this.hSl;
    }

    public String cds() {
        return this.bhP;
    }

    public void Fp(String str) {
        this.bhP = str;
    }

    public String cdt() {
        return this.eNF;
    }

    public void Fq(String str) {
        this.eNF = str;
    }
}
