package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class j {
    private long azH;
    private String imgUrl;

    public long Ct() {
        return this.azH;
    }

    public void Q(long j) {
        this.azH = j;
    }

    public String pL() {
        return this.imgUrl;
    }

    public void cB(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.azH = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
