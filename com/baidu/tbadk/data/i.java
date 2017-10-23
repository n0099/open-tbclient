package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class i {
    private long azq;
    private String imgUrl;

    public long BU() {
        return this.azq;
    }

    public void Q(long j) {
        this.azq = j;
    }

    public String pL() {
        return this.imgUrl;
    }

    public void cz(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.azq = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
