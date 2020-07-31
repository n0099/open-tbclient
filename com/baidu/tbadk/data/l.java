package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long eze;
    private String imgUrl;

    public long bin() {
        return this.eze;
    }

    public void cN(long j) {
        this.eze = j;
    }

    public String aUh() {
        return this.imgUrl;
    }

    public void wU(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.eze = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
