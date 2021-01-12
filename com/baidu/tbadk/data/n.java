package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class n {
    private long fxX;
    private String imgUrl;

    public long bAo() {
        return this.fxX;
    }

    public void ee(long j) {
        this.fxX = j;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void zM(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.fxX = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
