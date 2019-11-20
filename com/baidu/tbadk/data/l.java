package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class l {
    private long cDo;
    private String imgUrl;

    public long atC() {
        return this.cDo;
    }

    public void aZ(long j) {
        this.cDo = j;
    }

    public String ahd() {
        return this.imgUrl;
    }

    public void mU(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.cDo = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
