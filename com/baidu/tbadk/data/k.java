package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class k {
    private long atA;
    private String imgUrl;

    public long Co() {
        return this.atA;
    }

    public void P(long j) {
        this.atA = j;
    }

    public String pR() {
        return this.imgUrl;
    }

    public void cs(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.atA = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
