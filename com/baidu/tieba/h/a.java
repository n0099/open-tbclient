package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cXJ;
    private String fYW;
    private String fYX;
    private String fYY;
    private String fYZ;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.fYW = String.valueOf(esportRank.rank);
            this.fYX = esportRank.text;
            this.cXJ = esportRank.url;
            if (esportRank.user != null) {
                this.fYY = esportRank.user.steam_name;
                this.fYZ = esportRank.user.steam_portrait;
            }
        }
    }

    public String buI() {
        return this.mTitle;
    }

    public String buJ() {
        return this.fYW;
    }

    public String buK() {
        return this.fYX;
    }

    public String buL() {
        return this.fYY;
    }

    public String buM() {
        return this.fYZ;
    }

    public String buN() {
        return this.mImgUrl;
    }

    public void yn(String str) {
        this.mImgUrl = str;
    }

    public String buO() {
        return this.cXJ;
    }

    public void yo(String str) {
        this.cXJ = str;
    }
}
