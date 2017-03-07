package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long axE;
    private String imgUrl;

    public long Cq() {
        return this.axE;
    }

    public void N(long j) {
        this.axE = j;
    }

    public String qd() {
        return this.imgUrl;
    }

    public void ck(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.axE = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
