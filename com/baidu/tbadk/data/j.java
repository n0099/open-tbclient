package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long asF;
    private String imgUrl;

    public long Cg() {
        return this.asF;
    }

    public void Q(long j) {
        this.asF = j;
    }

    public String pO() {
        return this.imgUrl;
    }

    public void cq(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.asF = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
