package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class i {
    private long aLd;
    private String imgUrl;

    public long Hd() {
        return this.aLd;
    }

    public void X(long j) {
        this.aLd = j;
    }

    public String uh() {
        return this.imgUrl;
    }

    public void dm(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aLd = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
