package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long dwe;
    private String imgUrl;

    public long aOd() {
        return this.dwe;
    }

    public void bI(long j) {
        this.dwe = j;
    }

    public String aAJ() {
        return this.imgUrl;
    }

    public void sB(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.dwe = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
