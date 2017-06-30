package com.baidu.tieba.g;

import tbclient.EsportRank;
/* loaded from: classes.dex */
public class a {
    private String cwm;
    private String cwn;
    private String cwo;
    private String cwp;
    private String cwq;
    private String cwr;
    private String mTitle;

    public void a(EsportRank esportRank) {
        if (esportRank != null) {
            this.mTitle = esportRank.title;
            this.cwm = String.valueOf(esportRank.rank);
            this.cwn = esportRank.text;
            this.cwr = esportRank.url;
            if (esportRank.user != null) {
                this.cwo = esportRank.user.steam_name;
                this.cwp = esportRank.user.steam_portrait;
            }
        }
    }

    public String ajh() {
        return this.mTitle;
    }

    public String aji() {
        return this.cwm;
    }

    public String ajj() {
        return this.cwn;
    }

    public String ajk() {
        return this.cwo;
    }

    public String ajl() {
        return this.cwp;
    }

    public String ajm() {
        return this.cwq;
    }

    public void kp(String str) {
        this.cwq = str;
    }

    public String ajn() {
        return this.cwr;
    }

    public void kq(String str) {
        this.cwr = str;
    }
}
