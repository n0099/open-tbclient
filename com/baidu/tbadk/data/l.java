package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long cpH;
    private String imgUrl;

    public long aqx() {
        return this.cpH;
    }

    public void bg(long j) {
        this.cpH = j;
    }

    public String abS() {
        return this.imgUrl;
    }

    public void mk(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.cpH = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
