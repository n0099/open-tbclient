package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aSL;
    private String bsZ;
    private String fnP;
    private String iAT;
    private String iAU;
    private String iAV;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.iAT = String.valueOf(esportRank.rank);
            this.aSL = esportRank.text;
            this.fnP = esportRank.url;
            if (esportRank.user != null) {
                this.iAU = esportRank.user.steam_name;
                this.iAV = esportRank.user.steam_portrait;
            }
        }
    }

    public String cuP() {
        return this.mTitle;
    }

    public String cuQ() {
        return this.iAT;
    }

    public String cuR() {
        return this.aSL;
    }

    public String cuS() {
        return this.iAU;
    }

    public String cuT() {
        return this.iAV;
    }

    public String cuU() {
        return this.bsZ;
    }

    public void Je(String str) {
        this.bsZ = str;
    }

    public String cuV() {
        return this.fnP;
    }

    public void Jf(String str) {
        this.fnP = str;
    }
}
