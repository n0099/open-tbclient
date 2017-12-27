package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long boO;
    private String imgUrl;

    public long Kh() {
        return this.boO;
    }

    public void ab(long j) {
        this.boO = j;
    }

    public String xu() {
        return this.imgUrl;
    }

    public void cM(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.boO = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
