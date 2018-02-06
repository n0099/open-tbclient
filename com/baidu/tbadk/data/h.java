package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long bru;
    private String imgUrl;

    public long KE() {
        return this.bru;
    }

    public void ab(long j) {
        this.bru = j;
    }

    public String ya() {
        return this.imgUrl;
    }

    public void cX(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.bru = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
