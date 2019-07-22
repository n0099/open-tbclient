package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long cqT;
    private String imgUrl;

    public long arC() {
        return this.cqT;
    }

    public void bh(long j) {
        this.cqT = j;
    }

    public String acU() {
        return this.imgUrl;
    }

    public void mv(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.cqT = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
