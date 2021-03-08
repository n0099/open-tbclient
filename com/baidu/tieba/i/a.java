package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bUz;
    private String bei;
    private String gih;
    private String jWp;
    private String jWq;
    private String jWr;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jWp = String.valueOf(esportRank.rank);
            this.bei = esportRank.text;
            this.gih = esportRank.url;
            if (esportRank.user != null) {
                this.jWq = esportRank.user.steam_name;
                this.jWr = esportRank.user.steam_portrait;
            }
        }
    }

    public String cHt() {
        return this.mTitle;
    }

    public String cNP() {
        return this.jWp;
    }

    public String cNQ() {
        return this.bei;
    }

    public String cNR() {
        return this.jWq;
    }

    public String cNS() {
        return this.jWr;
    }

    public String cNT() {
        return this.bUz;
    }

    public void LA(String str) {
        this.bUz = str;
    }

    public String cNU() {
        return this.gih;
    }

    public void LB(String str) {
        this.gih = str;
    }
}
