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

    public String alu() {
        return this.mTitle;
    }

    public String alv() {
        return this.cGO;
    }

    public String alw() {
        return this.cGP;
    }

    public String alx() {
        return this.cGQ;
    }

    public String aly() {
        return this.cGR;
    }

    public String alz() {
        return this.cGS;
    }

    public void kN(String str) {
        this.cGS = str;
    }

    public String alA() {
        return this.cGT;
    }

    public void kO(String str) {
        this.cGT = str;
    }
}
