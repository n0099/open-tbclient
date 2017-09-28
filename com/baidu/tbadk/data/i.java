package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class i {
    private long azC;
    private String imgUrl;

    public long Ca() {
        return this.azC;
    }

    public void P(long j) {
        this.azC = j;
    }

    public String pS() {
        return this.imgUrl;
    }

    public void cA(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.azC = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
