package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bSZ;
    private String bcH;
    private String ggy;
    private String jTZ;
    private String jUa;
    private String jUb;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jTZ = String.valueOf(esportRank.rank);
            this.bcH = esportRank.text;
            this.ggy = esportRank.url;
            if (esportRank.user != null) {
                this.jUa = esportRank.user.steam_name;
                this.jUb = esportRank.user.steam_portrait;
            }
        }
    }

    public String cHg() {
        return this.mTitle;
    }

    public String cNB() {
        return this.jTZ;
    }

    public String cNC() {
        return this.bcH;
    }

    public String cND() {
        return this.jUa;
    }

    public String cNE() {
        return this.jUb;
    }

    public String cNF() {
        return this.bSZ;
    }

    public void Lt(String str) {
        this.bSZ = str;
    }

    public String cNG() {
        return this.ggy;
    }

    public void Lu(String str) {
        this.ggy = str;
    }
}
