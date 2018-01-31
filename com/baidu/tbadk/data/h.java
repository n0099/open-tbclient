package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class h {
    private long bpg;
    private String imgUrl;

    public long JY() {
        return this.bpg;
    }

    public void ab(long j) {
        this.bpg = j;
    }

    public String xu() {
        return this.imgUrl;
    }

    public void cM(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.bpg = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
