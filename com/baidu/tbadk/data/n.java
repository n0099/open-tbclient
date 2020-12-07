package com.baidu.tbadk.data;

import tbclient.Pendant;
/* loaded from: classes.dex */
public class n {
    private long fsZ;
    private String imgUrl;

    public long bBM() {
        return this.fsZ;
    }

    public void ee(long j) {
        this.fsZ = j;
    }

    public String bmL() {
        return this.imgUrl;
    }

    public void AZ(String str) {
        this.imgUrl = str;
    }

    public void a(Pendant pendant) {
        if (pendant != null) {
            this.fsZ = pendant.props_id.longValue();
            this.imgUrl = pendant.img_url;
        }
    }
}
