package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long aAb;
    private String imgUrl;

    public long Cj() {
        return this.aAb;
    }

    public void Q(long j) {
        this.aAb = j;
    }

    public String pQ() {
        return this.imgUrl;
    }

    public void cF(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aAb = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
