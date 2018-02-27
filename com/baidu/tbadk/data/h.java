package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long brh;
    private String imgUrl;

    public long KD() {
        return this.brh;
    }

    public void ab(long j) {
        this.brh = j;
    }

    public String ya() {
        return this.imgUrl;
    }

    public void cX(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.brh = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
