package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long aAj;
    private String imgUrl;

    public long Cv() {
        return this.aAj;
    }

    public void Q(long j) {
        this.aAj = j;
    }

    public String pQ() {
        return this.imgUrl;
    }

    public void cF(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aAj = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
