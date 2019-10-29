package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long cEf;
    private String imgUrl;

    public long atE() {
        return this.cEf;
    }

    public void ba(long j) {
        this.cEf = j;
    }

    public String ahf() {
        return this.imgUrl;
    }

    public void mU(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.cEf = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
