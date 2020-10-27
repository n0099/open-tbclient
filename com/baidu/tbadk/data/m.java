package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long fgv;
    private String imgUrl;

    public long bwx() {
        return this.fgv;
    }

    public void dj(long j) {
        this.fgv = j;
    }

    public String bhW() {
        return this.imgUrl;
    }

    public void AJ(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.fgv = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
