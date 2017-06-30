package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long ayH;
    private String imgUrl;

    public long Ch() {
        return this.ayH;
    }

    public void P(long j) {
        this.ayH = j;
    }

    public String pI() {
        return this.imgUrl;
    }

    public void cw(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.ayH = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
