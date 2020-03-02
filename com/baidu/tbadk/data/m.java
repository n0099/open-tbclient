package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long dvE;
    private String imgUrl;

    public long aNY() {
        return this.dvE;
    }

    public void bI(long j) {
        this.dvE = j;
    }

    public String aAG() {
        return this.imgUrl;
    }

    public void sB(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.dvE = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
