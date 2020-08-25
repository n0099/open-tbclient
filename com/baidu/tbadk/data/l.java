package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes2.dex */
public class l {
    private long eJC;
    private String imgUrl;

    public long bqZ() {
        return this.eJC;
    }

    public void cY(long j) {
        this.eJC = j;
    }

    public String bcA() {
        return this.imgUrl;
    }

    public void zi(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.eJC = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
