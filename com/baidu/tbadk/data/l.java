package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long cpG;
    private String imgUrl;

    public long aqx() {
        return this.cpG;
    }

    public void bg(long j) {
        this.cpG = j;
    }

    public String abS() {
        return this.imgUrl;
    }

    public void ml(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.cpG = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
