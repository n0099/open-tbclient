package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bOR;
    private String bcG;
    private String fZl;
    private String jDK;
    private String jDL;
    private String jDM;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jDK = String.valueOf(esportRank.rank);
            this.bcG = esportRank.text;
            this.fZl = esportRank.url;
            if (esportRank.user != null) {
                this.jDL = esportRank.user.steam_name;
                this.jDM = esportRank.user.steam_portrait;
            }
        }
    }

    public String cGL() {
        return this.mTitle;
    }

    public String cMi() {
        return this.jDK;
    }

    public String cMj() {
        return this.bcG;
    }

    public String cMk() {
        return this.jDL;
    }

    public String cMl() {
        return this.jDM;
    }

    public String cMm() {
        return this.bOR;
    }

    public void LN(String str) {
        this.bOR = str;
    }

    public String cMn() {
        return this.fZl;
    }

    public void LO(String str) {
        this.fZl = str;
    }
}
