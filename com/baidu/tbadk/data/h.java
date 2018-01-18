package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long boX;
    private String imgUrl;

    public long JW() {
        return this.boX;
    }

    public void ab(long j) {
        this.boX = j;
    }

    public String xt() {
        return this.imgUrl;
    }

    public void cM(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.boX = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
