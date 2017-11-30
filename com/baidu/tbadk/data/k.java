package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long aAK;
    private String imgUrl;

    public long CE() {
        return this.aAK;
    }

    public void T(long j) {
        this.aAK = j;
    }

    public String pT() {
        return this.imgUrl;
    }

    public void cF(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aAK = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
