package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long atd;
    private String imgUrl;

    public long Cb() {
        return this.atd;
    }

    public void O(long j) {
        this.atd = j;
    }

    public String pS() {
        return this.imgUrl;
    }

    public void cs(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.atd = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
