package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes2.dex */
public class a {
    private String aSJ;
    private String bsW;
    private String fnL;
    private String iAN;
    private String iAO;
    private String iAP;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.iAN = String.valueOf(esportRank.rank);
            this.aSJ = esportRank.text;
            this.fnL = esportRank.url;
            if (esportRank.user != null) {
                this.iAO = esportRank.user.steam_name;
                this.iAP = esportRank.user.steam_portrait;
            }
        }
    }

    public String cuO() {
        return this.mTitle;
    }

    public String cuP() {
        return this.iAN;
    }

    public String cuQ() {
        return this.aSJ;
    }

    public String cuR() {
        return this.iAO;
    }

    public String cuS() {
        return this.iAP;
    }

    public String cuT() {
        return this.bsW;
    }

    public void Jd(String str) {
        this.bsW = str;
    }

    public String cuU() {
        return this.fnL;
    }

    public void Je(String str) {
        this.fnL = str;
    }
}
