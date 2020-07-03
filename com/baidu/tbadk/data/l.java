package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long esK;
    private String imgUrl;

    public long beE() {
        return this.esK;
    }

    public void ct(long j) {
        this.esK = j;
    }

    public String aQl() {
        return this.imgUrl;
    }

    public void vN(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.esK = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
