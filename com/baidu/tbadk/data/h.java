package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long aBK;
    private String imgUrl;

    public long Di() {
        return this.aBK;
    }

    public void T(long j) {
        this.aBK = j;
    }

    public String qF() {
        return this.imgUrl;
    }

    public void cL(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aBK = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
