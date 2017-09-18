package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aAi;
    private String imgUrl;

    public long Cw() {
        return this.aAi;
    }

    public void P(long j) {
        this.aAi = j;
    }

    public String pR() {
        return this.imgUrl;
    }

    public void cA(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aAi = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
