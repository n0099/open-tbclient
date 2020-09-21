package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aUW;
    private String bwq;
    private String fqU;
    private String iIo;
    private String iIp;
    private String iIq;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.iIo = String.valueOf(esportRank.rank);
            this.aUW = esportRank.text;
            this.fqU = esportRank.url;
            if (esportRank.user != null) {
                this.iIp = esportRank.user.steam_name;
                this.iIq = esportRank.user.steam_portrait;
            }
        }
    }

    public String cyi() {
        return this.mTitle;
    }

    public String cyj() {
        return this.iIo;
    }

    public String cyk() {
        return this.aUW;
    }

    public String cyl() {
        return this.iIp;
    }

    public String cym() {
        return this.iIq;
    }

    public String cyn() {
        return this.bwq;
    }

    public void JC(String str) {
        this.bwq = str;
    }

    public String cyo() {
        return this.fqU;
    }

    public void JD(String str) {
        this.fqU = str;
    }
}
