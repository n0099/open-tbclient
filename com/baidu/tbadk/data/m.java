package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long drk;
    private String imgUrl;

    public long aLh() {
        return this.drk;
    }

    public void bB(long j) {
        this.drk = j;
    }

    public String axX() {
        return this.imgUrl;
    }

    public void sh(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.drk = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
