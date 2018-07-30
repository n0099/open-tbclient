package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class i {
    private long aLj;
    private String imgUrl;

    public long GZ() {
        return this.aLj;
    }

    public void Z(long j) {
        this.aLj = j;
    }

    public String tU() {
        return this.imgUrl;
    }

    public void dj(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aLj = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
