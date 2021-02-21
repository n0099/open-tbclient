package com.baidu.tieba.i;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bSZ;
    private String bcH;
    private String ggD;
    private String jUn;
    private String jUo;
    private String jUp;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.jUn = String.valueOf(esportRank.rank);
            this.bcH = esportRank.text;
            this.ggD = esportRank.url;
            if (esportRank.user != null) {
                this.jUo = esportRank.user.steam_name;
                this.jUp = esportRank.user.steam_portrait;
            }
        }
    }

    public String cHn() {
        return this.mTitle;
    }

    public String cNI() {
        return this.jUn;
    }

    public String cNJ() {
        return this.bcH;
    }

    public String cNK() {
        return this.jUo;
    }

    public String cNL() {
        return this.jUp;
    }

    public String cNM() {
        return this.bSZ;
    }

    public void Lu(String str) {
        this.bSZ = str;
    }

    public String cNN() {
        return this.ggD;
    }

    public void Lv(String str) {
        this.ggD = str;
    }
}
