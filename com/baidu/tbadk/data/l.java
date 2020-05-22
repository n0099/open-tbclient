package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long ejZ;
    private String imgUrl;

    public long bcB() {
        return this.ejZ;
    }

    public void cr(long j) {
        this.ejZ = j;
    }

    public String aOP() {
        return this.imgUrl;
    }

    public void vx(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.ejZ = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
