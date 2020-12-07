package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bOR;
    private String bcG;
    private String fZj;
    private String jDI;
    private String jDJ;
    private String jDK;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jDI = String.valueOf(esportRank.rank);
            this.bcG = esportRank.text;
            this.fZj = esportRank.url;
            if (esportRank.user != null) {
                this.jDJ = esportRank.user.steam_name;
                this.jDK = esportRank.user.steam_portrait;
            }
        }
    }

    public String cGK() {
        return this.mTitle;
    }

    public String cMh() {
        return this.jDI;
    }

    public String cMi() {
        return this.bcG;
    }

    public String cMj() {
        return this.jDJ;
    }

    public String cMk() {
        return this.jDK;
    }

    public String cMl() {
        return this.bOR;
    }

    public void LN(String str) {
        this.bOR = str;
    }

    public String cMm() {
        return this.fZj;
    }

    public void LO(String str) {
        this.fZj = str;
    }
}
