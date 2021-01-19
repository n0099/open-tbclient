package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String aZA;
    private String bPj;
    private String gej;
    private String jMx;
    private String jMy;
    private String jMz;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jMx = String.valueOf(esportRank.rank);
            this.aZA = esportRank.text;
            this.gej = esportRank.url;
            if (esportRank.user != null) {
                this.jMy = esportRank.user.steam_name;
                this.jMz = esportRank.user.steam_portrait;
            }
        }
    }

    public String cFT() {
        return this.mTitle;
    }

    public String cLE() {
        return this.jMx;
    }

    public String cLF() {
        return this.aZA;
    }

    public String cLG() {
        return this.jMy;
    }

    public String cLH() {
        return this.jMz;
    }

    public String cLI() {
        return this.bPj;
    }

    public void KG(String str) {
        this.bPj = str;
    }

    public String cLJ() {
        return this.gej;
    }

    public void KH(String str) {
        this.gej = str;
    }
}
