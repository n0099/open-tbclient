package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long aBJ;
    private String imgUrl;

    public long Dk() {
        return this.aBJ;
    }

    public void T(long j) {
        this.aBJ = j;
    }

    public String qG() {
        return this.imgUrl;
    }

    public void cL(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aBJ = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
