package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String dVU;
    private String dVV;
    private String dVW;
    private String dVX;
    private String dVY;
    private String dVZ;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dVU = String.valueOf(esportRank.rank);
            this.dVV = esportRank.text;
            this.dVZ = esportRank.url;
            if (esportRank.user != null) {
                this.dVW = esportRank.user.steam_name;
                this.dVX = esportRank.user.steam_portrait;
            }
        }
    }

    public String azE() {
        return this.mTitle;
    }

    public String azF() {
        return this.dVU;
    }

    public String azG() {
        return this.dVV;
    }

    public String azH() {
        return this.dVW;
    }

    public String azI() {
        return this.dVX;
    }

    public String azJ() {
        return this.dVY;
    }

    public void mk(String str) {
        this.dVY = str;
    }

    public String azK() {
        return this.dVZ;
    }

    public void ml(String str) {
        this.dVZ = str;
    }
}
