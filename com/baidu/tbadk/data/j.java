package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aTa;
    private String imgUrl;

    public long Ko() {
        return this.aTa;
    }

    public void af(long j) {
        this.aTa = j;
    }

    public String xf() {
        return this.imgUrl;
    }

    public void dR(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aTa = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
