package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bcH;
    private String dvW;
    private String dvX;
    private String dvY;
    private String dvZ;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.dvW = String.valueOf(esportRank.rank);
            this.dvX = esportRank.text;
            this.bcH = esportRank.url;
            if (esportRank.user != null) {
                this.dvY = esportRank.user.steam_name;
                this.dvZ = esportRank.user.steam_portrait;
            }
        }
    }

    public String avT() {
        return this.mTitle;
    }

    public String avU() {
        return this.dvW;
    }

    public String avV() {
        return this.dvX;
    }

    public String avW() {
        return this.dvY;
    }

    public String avX() {
        return this.dvZ;
    }

    public String avY() {
        return this.mImgUrl;
    }

    public void mz(String str) {
        this.mImgUrl = str;
    }

    public String avZ() {
        return this.bcH;
    }

    public void mA(String str) {
        this.bcH = str;
    }
}
