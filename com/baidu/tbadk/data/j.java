package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long asU;
    private String imgUrl;

    public long Cd() {
        return this.asU;
    }

    public void P(long j) {
        this.asU = j;
    }

    public String rc() {
        return this.imgUrl;
    }

    public void cq(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.asU = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
