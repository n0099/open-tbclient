package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aXn;
    private String imgUrl;

    public long LE() {
        return this.aXn;
    }

    public void ao(long j) {
        this.aXn = j;
    }

    public String ys() {
        return this.imgUrl;
    }

    public void ej(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aXn = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
