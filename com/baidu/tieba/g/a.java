package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cDA;
    private String cDB;
    private String cDw;
    private String cDx;
    private String cDy;
    private String cDz;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cDw = String.valueOf(esportRank.rank);
            this.cDx = esportRank.text;
            this.cDB = esportRank.url;
            if (esportRank.user != null) {
                this.cDy = esportRank.user.steam_name;
                this.cDz = esportRank.user.steam_portrait;
            }
        }
    }

    public String akH() {
        return this.mTitle;
    }

    public String akI() {
        return this.cDw;
    }

    public String akJ() {
        return this.cDx;
    }

    public String akK() {
        return this.cDy;
    }

    public String akL() {
        return this.cDz;
    }

    public String akM() {
        return this.cDA;
    }

    public void kC(String str) {
        this.cDA = str;
    }

    public String akN() {
        return this.cDB;
    }

    public void kD(String str) {
        this.cDB = str;
    }
}
