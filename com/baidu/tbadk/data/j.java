package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aBa;
    private String imgUrl;

    public long CB() {
        return this.aBa;
    }

    public void Q(long j) {
        this.aBa = j;
    }

    public String pW() {
        return this.imgUrl;
    }

    public void cK(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aBa = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
