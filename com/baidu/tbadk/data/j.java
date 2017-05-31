package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long axF;
    private String imgUrl;

    public long BN() {
        return this.axF;
    }

    public void O(long j) {
        this.axF = j;
    }

    public String pL() {
        return this.imgUrl;
    }

    public void cq(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.axF = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
