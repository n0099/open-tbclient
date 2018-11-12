package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aTQ;
    private String imgUrl;

    public long KA() {
        return this.aTQ;
    }

    public void ah(long j) {
        this.aTQ = j;
    }

    public String xn() {
        return this.imgUrl;
    }

    public void dR(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aTQ = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
