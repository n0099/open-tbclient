package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long axW;
    private String imgUrl;

    public long CO() {
        return this.axW;
    }

    public void N(long j) {
        this.axW = j;
    }

    public String qB() {
        return this.imgUrl;
    }

    public void cr(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.axW = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
