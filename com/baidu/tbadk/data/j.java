package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long aAY;
    private String imgUrl;

    public long CB() {
        return this.aAY;
    }

    public void Q(long j) {
        this.aAY = j;
    }

    public String pV() {
        return this.imgUrl;
    }

    public void cH(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.aAY = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
