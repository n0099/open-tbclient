package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long flw;
    private String imgUrl;

    public long bym() {
        return this.flw;
    }

    public void dF(long j) {
        this.flw = j;
    }

    public String bjy() {
        return this.imgUrl;
    }

    public void As(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.flw = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
