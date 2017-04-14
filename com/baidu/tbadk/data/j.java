package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long axU;
    private String imgUrl;

    public long CO() {
        return this.axU;
    }

    public void N(long j) {
        this.axU = j;
    }

    public String qB() {
        return this.imgUrl;
    }

    public void cr(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.axU = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
