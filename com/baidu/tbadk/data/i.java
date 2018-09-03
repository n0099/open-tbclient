package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class i {
    private long aLg;
    private String imgUrl;

    public long GZ() {
        return this.aLg;
    }

    public void Z(long j) {
        this.aLg = j;
    }

    public String tT() {
        return this.imgUrl;
    }

    public void dj(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aLg = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
