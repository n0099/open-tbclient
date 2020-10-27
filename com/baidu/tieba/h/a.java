package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aZC;
    private String bFP;
    private String fLC;
    private String jjD;
    private String jjE;
    private String jjF;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jjD = String.valueOf(esportRank.rank);
            this.aZC = esportRank.text;
            this.fLC = esportRank.url;
            if (esportRank.user != null) {
                this.jjE = esportRank.user.steam_name;
                this.jjF = esportRank.user.steam_portrait;
            }
        }
    }

    public String cEM() {
        return this.mTitle;
    }

    public String cEN() {
        return this.jjD;
    }

    public String cEO() {
        return this.aZC;
    }

    public String cEP() {
        return this.jjE;
    }

    public String cEQ() {
        return this.jjF;
    }

    public String cER() {
        return this.bFP;
    }

    public void KO(String str) {
        this.bFP = str;
    }

    public String cES() {
        return this.fLC;
    }

    public void KP(String str) {
        this.fLC = str;
    }
}
