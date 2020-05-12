package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aDW;
    private String bas;
    private String eyU;
    private String hCJ;
    private String hCK;
    private String hCL;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.hCJ = String.valueOf(esportRank.rank);
            this.aDW = esportRank.text;
            this.eyU = esportRank.url;
            if (esportRank.user != null) {
                this.hCK = esportRank.user.steam_name;
                this.hCL = esportRank.user.steam_portrait;
            }
        }
    }

    public String bWH() {
        return this.mTitle;
    }

    public String bWI() {
        return this.hCJ;
    }

    public String bWJ() {
        return this.aDW;
    }

    public String bWK() {
        return this.hCK;
    }

    public String bWL() {
        return this.hCL;
    }

    public String bWM() {
        return this.bas;
    }

    public void DG(String str) {
        this.bas = str;
    }

    public String bWN() {
        return this.eyU;
    }

    public void DH(String str) {
        this.eyU = str;
    }
}
