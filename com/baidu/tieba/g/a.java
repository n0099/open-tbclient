package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cGO;
    private String cGP;
    private String cGQ;
    private String cGR;
    private String cGS;
    private String cGT;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cGO = String.valueOf(esportRank.rank);
            this.cGP = esportRank.text;
            this.cGT = esportRank.url;
            if (esportRank.user != null) {
                this.cGQ = esportRank.user.steam_name;
                this.cGR = esportRank.user.steam_portrait;
            }
        }
    }

    public String alA() {
        return this.mTitle;
    }

    public String alB() {
        return this.cGO;
    }

    public String alC() {
        return this.cGP;
    }

    public String alD() {
        return this.cGQ;
    }

    public String alE() {
        return this.cGR;
    }

    public String alF() {
        return this.cGS;
    }

    public void kK(String str) {
        this.cGS = str;
    }

    public String alG() {
        return this.cGT;
    }

    public void kL(String str) {
        this.cGT = str;
    }
}
