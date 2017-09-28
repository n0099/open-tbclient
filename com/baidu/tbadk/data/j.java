package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class j implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId azD = BdUniqueId.gen();
    private String azE;
    private String azF;
    private boolean azG = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azD;
    }

    public String Cb() {
        return this.azE;
    }

    public void fo(String str) {
        this.azE = str;
    }

    public String getSmallUrl() {
        return this.azF;
    }

    public void fp(String str) {
        this.azF = str;
    }

    public boolean Cc() {
        return this.azG;
    }

    public void bv(boolean z) {
        this.azG = z;
    }
}
