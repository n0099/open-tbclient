package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aOy;
    private String imgUrl;

    public long Ip() {
        return this.aOy;
    }

    public void ad(long j) {
        this.aOy = j;
    }

    public String uW() {
        return this.imgUrl;
    }

    public void dB(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aOy = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
