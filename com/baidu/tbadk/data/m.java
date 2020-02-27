package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long dvD;
    private String imgUrl;

    public long aNW() {
        return this.dvD;
    }

    public void bI(long j) {
        this.dvD = j;
    }

    public String aAE() {
        return this.imgUrl;
    }

    public void sB(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.dvD = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
