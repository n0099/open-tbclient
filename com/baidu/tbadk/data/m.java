package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class m {
    private long eXZ;
    private String imgUrl;

    public long buE() {
        return this.eXZ;
    }

    public void dh(long j) {
        this.eXZ = j;
    }

    public String bgd() {
        return this.imgUrl;
    }

    public void Aq(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.eXZ = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
