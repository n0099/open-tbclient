package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cXW;
    private String cXX;
    private String cXY;
    private String cXZ;
    private String cYa;
    private String cYb;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cXW = String.valueOf(esportRank.rank);
            this.cXX = esportRank.text;
            this.cYb = esportRank.url;
            if (esportRank.user != null) {
                this.cXY = esportRank.user.steam_name;
                this.cXZ = esportRank.user.steam_portrait;
            }
        }
    }

    public String apX() {
        return this.mTitle;
    }

    public String apY() {
        return this.cXW;
    }

    public String apZ() {
        return this.cXX;
    }

    public String aqa() {
        return this.cXY;
    }

    public String aqb() {
        return this.cXZ;
    }

    public String aqc() {
        return this.cYa;
    }

    public void lD(String str) {
        this.cYa = str;
    }

    public String aqd() {
        return this.cYb;
    }

    public void lE(String str) {
        this.cYb = str;
    }
}
