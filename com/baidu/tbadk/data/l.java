package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long crV;
    private String imgUrl;

    public long arQ() {
        return this.crV;
    }

    public void bk(long j) {
        this.crV = j;
    }

    public String acZ() {
        return this.imgUrl;
    }

    public void mx(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.crV = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
