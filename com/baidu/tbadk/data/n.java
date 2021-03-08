package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class n {
    private long fBM;
    private String imgUrl;

    public long bAJ() {
        return this.fBM;
    }

    public void ek(long j) {
        this.fBM = j;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void Ak(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.fBM = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
