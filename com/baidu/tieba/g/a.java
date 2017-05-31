package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String coA;
    private String coB;
    private String coC;
    private String cox;
    private String coy;
    private String coz;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cox = String.valueOf(esportRank.rank);
            this.coy = esportRank.text;
            this.coC = esportRank.url;
            if (esportRank.user != null) {
                this.coz = esportRank.user.steam_name;
                this.coA = esportRank.user.steam_portrait;
            }
        }
    }

    public String afx() {
        return this.mTitle;
    }

    public String afy() {
        return this.cox;
    }

    public String afz() {
        return this.coy;
    }

    public String afA() {
        return this.coz;
    }

    public String afB() {
        return this.coA;
    }

    public String afC() {
        return this.coB;
    }

    public void jr(String str) {
        this.coB = str;
    }

    public String afD() {
        return this.coC;
    }

    public void js(String str) {
        this.coC = str;
    }
}
