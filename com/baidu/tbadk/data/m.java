package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long drw;
    private String imgUrl;

    public long aLA() {
        return this.drw;
    }

    public void bE(long j) {
        this.drw = j;
    }

    public String ayq() {
        return this.imgUrl;
    }

    public void sk(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.drw = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
