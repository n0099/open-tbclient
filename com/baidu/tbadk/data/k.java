package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long dVL;
    private String imgUrl;

    public long aWu() {
        return this.dVL;
    }

    public void cp(long j) {
        this.dVL = j;
    }

    public String aIW() {
        return this.imgUrl;
    }

    public void tO(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.dVL = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
