package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class n {
    private long fCF;
    private String imgUrl;

    public long bEi() {
        return this.fCF;
    }

    public void ee(long j) {
        this.fCF = j;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void AX(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.fCF = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
