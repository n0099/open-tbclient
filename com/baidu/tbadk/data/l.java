package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long chx;
    private String imgUrl;

    public long alu() {
        return this.chx;
    }

    public void aR(long j) {
        this.chx = j;
    }

    public String Xk() {
        return this.imgUrl;
    }

    public void lg(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.chx = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
