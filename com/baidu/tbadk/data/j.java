package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aXq;
    private String imgUrl;

    public long LF() {
        return this.aXq;
    }

    public void ap(long j) {
        this.aXq = j;
    }

    public String ys() {
        return this.imgUrl;
    }

    public void ej(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aXq = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
