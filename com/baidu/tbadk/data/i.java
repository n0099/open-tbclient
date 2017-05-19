package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class i {
    private long axT;
    private String imgUrl;

    public long BT() {
        return this.axT;
    }

    public void O(long j) {
        this.axT = j;
    }

    public String pT() {
        return this.imgUrl;
    }

    public void cr(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.axT = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
