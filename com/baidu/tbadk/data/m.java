package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long eLS;
    private String imgUrl;

    public long brU() {
        return this.eLS;
    }

    public void cZ(long j) {
        this.eLS = j;
    }

    public String bdu() {
        return this.imgUrl;
    }

    public void zE(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.eLS = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
