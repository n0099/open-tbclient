package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long cra;
    private String imgUrl;

    public long arE() {
        return this.cra;
    }

    public void bh(long j) {
        this.cra = j;
    }

    public String acV() {
        return this.imgUrl;
    }

    public void mv(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.cra = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
