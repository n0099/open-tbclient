package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String arG;
    private String dgp;
    private String fXA;
    private String fXB;
    private String fXC;
    private String fXD;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fXA = String.valueOf(esportRank.rank);
            this.fXB = esportRank.text;
            this.dgp = esportRank.url;
            if (esportRank.user != null) {
                this.fXC = esportRank.user.steam_name;
                this.fXD = esportRank.user.steam_portrait;
            }
        }
    }

    public String brI() {
        return this.mTitle;
    }

    public String brJ() {
        return this.fXA;
    }

    public String brK() {
        return this.fXB;
    }

    public String brL() {
        return this.fXC;
    }

    public String brM() {
        return this.fXD;
    }

    public String brN() {
        return this.arG;
    }

    public void wF(String str) {
        this.arG = str;
    }

    public String brO() {
        return this.dgp;
    }

    public void wG(String str) {
        this.dgp = str;
    }
}
