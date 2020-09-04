package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long eJG;
    private String imgUrl;

    public long bra() {
        return this.eJG;
    }

    public void cY(long j) {
        this.eJG = j;
    }

    public String bcA() {
        return this.imgUrl;
    }

    public void zj(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.eJG = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
