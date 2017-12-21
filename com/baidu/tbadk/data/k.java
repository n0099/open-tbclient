package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long aAS;
    private String imgUrl;

    public long CF() {
        return this.aAS;
    }

    public void T(long j) {
        this.aAS = j;
    }

    public String pR() {
        return this.imgUrl;
    }

    public void cF(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aAS = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
