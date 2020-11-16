package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aZj;
    private String bJJ;
    private String fRa;
    private String jqi;
    private String jqj;
    private String jqk;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jqi = String.valueOf(esportRank.rank);
            this.aZj = esportRank.text;
            this.fRa = esportRank.url;
            if (esportRank.user != null) {
                this.jqj = esportRank.user.steam_name;
                this.jqk = esportRank.user.steam_portrait;
            }
        }
    }

    public String cGS() {
        return this.mTitle;
    }

    public String cGT() {
        return this.jqi;
    }

    public String cGU() {
        return this.aZj;
    }

    public String cGV() {
        return this.jqj;
    }

    public String cGW() {
        return this.jqk;
    }

    public String cGX() {
        return this.bJJ;
    }

    public void KG(String str) {
        this.bJJ = str;
    }

    public String cGY() {
        return this.fRa;
    }

    public void KH(String str) {
        this.fRa = str;
    }
}
