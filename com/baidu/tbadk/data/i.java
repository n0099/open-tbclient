package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class i {
    private long aKg;
    private String imgUrl;

    public long GL() {
        return this.aKg;
    }

    public void W(long j) {
        this.aKg = j;
    }

    public String ub() {
        return this.imgUrl;
    }

    public void dj(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aKg = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
