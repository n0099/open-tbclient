package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long dVQ;
    private String imgUrl;

    public long aWs() {
        return this.dVQ;
    }

    public void cp(long j) {
        this.dVQ = j;
    }

    public String aIU() {
        return this.imgUrl;
    }

    public void tR(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.dVQ = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
