package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long chy;
    private String imgUrl;

    public long alu() {
        return this.chy;
    }

    public void aR(long j) {
        this.chy = j;
    }

    public String Xk() {
        return this.imgUrl;
    }

    public void lg(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.chy = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
