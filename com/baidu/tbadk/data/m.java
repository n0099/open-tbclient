package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long fmo;
    private String imgUrl;

    public long byW() {
        return this.fmo;
    }

    public void dF(long j) {
        this.fmo = j;
    }

    public String bkw() {
        return this.imgUrl;
    }

    public void AX(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.fmo = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
