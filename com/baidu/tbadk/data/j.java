package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long asj;
    private String imgUrl;

    public long BX() {
        return this.asj;
    }

    public void N(long j) {
        this.asj = j;
    }

    public String pL() {
        return this.imgUrl;
    }

    public void cq(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.asj = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
