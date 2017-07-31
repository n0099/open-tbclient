package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cER;
    private String cES;
    private String cET;
    private String cEU;
    private String cEV;
    private String cEW;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cER = String.valueOf(esportRank.rank);
            this.cES = esportRank.text;
            this.cEW = esportRank.url;
            if (esportRank.user != null) {
                this.cET = esportRank.user.steam_name;
                this.cEU = esportRank.user.steam_portrait;
            }
        }
    }

    public String akU() {
        return this.mTitle;
    }

    public String akV() {
        return this.cER;
    }

    public String akW() {
        return this.cES;
    }

    public String akX() {
        return this.cET;
    }

    public String akY() {
        return this.cEU;
    }

    public String akZ() {
        return this.cEV;
    }

    public void kG(String str) {
        this.cEV = str;
    }

    public String ala() {
        return this.cEW;
    }

    public void kH(String str) {
        this.cEW = str;
    }
}
