package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long dvR;
    private String imgUrl;

    public long aNZ() {
        return this.dvR;
    }

    public void bI(long j) {
        this.dvR = j;
    }

    public String aAG() {
        return this.imgUrl;
    }

    public void sB(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.dvR = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
