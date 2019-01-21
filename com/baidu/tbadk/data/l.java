package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long aYb;
    private String imgUrl;

    public long LW() {
        return this.aYb;
    }

    public void ap(long j) {
        this.aYb = j;
    }

    public String yF() {
        return this.imgUrl;
    }

    public void es(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aYb = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
