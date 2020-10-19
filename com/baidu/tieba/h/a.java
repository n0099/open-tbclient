package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aYh;
    private String bCT;
    private String fDh;
    private String iXg;
    private String iXh;
    private String iXi;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.iXg = String.valueOf(esportRank.rank);
            this.aYh = esportRank.text;
            this.fDh = esportRank.url;
            if (esportRank.user != null) {
                this.iXh = esportRank.user.steam_name;
                this.iXi = esportRank.user.steam_portrait;
            }
        }
    }

    public String cBF() {
        return this.mTitle;
    }

    public String cBG() {
        return this.iXg;
    }

    public String cBH() {
        return this.aYh;
    }

    public String cBI() {
        return this.iXh;
    }

    public String cBJ() {
        return this.iXi;
    }

    public String cBK() {
        return this.bCT;
    }

    public void Kp(String str) {
        this.bCT = str;
    }

    public String cBL() {
        return this.fDh;
    }

    public void Kq(String str) {
        this.fDh = str;
    }
}
