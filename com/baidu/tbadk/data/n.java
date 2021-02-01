package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class n {
    private long fAn;
    private String imgUrl;

    public long bAG() {
        return this.fAn;
    }

    public void ek(long j) {
        this.fAn = j;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void Ad(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.fAn = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
