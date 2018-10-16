package com.baidu.tieba.h;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String bwU;
    private String ect;
    private String ecu;
    private String ecv;
    private String ecw;
    private String mImgUrl;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.ect = String.valueOf(esportRank.rank);
            this.ecu = esportRank.text;
            this.bwU = esportRank.url;
            if (esportRank.user != null) {
                this.ecv = esportRank.user.steam_name;
                this.ecw = esportRank.user.steam_portrait;
            }
        }
    }

    public String aHC() {
        return this.mTitle;
    }

    public String aHD() {
        return this.ect;
    }

    public String aHE() {
        return this.ecu;
    }

    public String aHF() {
        return this.ecv;
    }

    public String aHG() {
        return this.ecw;
    }

    public String aHH() {
        return this.mImgUrl;
    }

    public void ou(String str) {
        this.mImgUrl = str;
    }

    public String aHI() {
        return this.bwU;
    }

    public void ov(String str) {
        this.bwU = str;
    }
}
