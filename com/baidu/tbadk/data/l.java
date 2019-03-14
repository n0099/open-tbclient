package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long chv;
    private String imgUrl;

    public long alx() {
        return this.chv;
    }

    public void aR(long j) {
        this.chv = j;
    }

    public String Xn() {
        return this.imgUrl;
    }

    public void lf(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.chv = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
