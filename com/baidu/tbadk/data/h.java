package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long brk;
    private String imgUrl;

    public long KE() {
        return this.brk;
    }

    public void ab(long j) {
        this.brk = j;
    }

    public String ya() {
        return this.imgUrl;
    }

    public void cX(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.brk = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
