package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aAl;
    private String imgUrl;

    public long Cw() {
        return this.aAl;
    }

    public void P(long j) {
        this.aAl = j;
    }

    public String pR() {
        return this.imgUrl;
    }

    public void cA(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aAl = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
