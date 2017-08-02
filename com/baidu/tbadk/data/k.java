package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId azI = BdUniqueId.gen();
    private String azJ;
    private String azK;
    private boolean azL = false;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return azI;
    }

    public String Cu() {
        return this.azJ;
    }

    public void fq(String str) {
        this.azJ = str;
    }

    public String getSmallUrl() {
        return this.azK;
    }

    public void fr(String str) {
        this.azK = str;
    }

    public boolean Cv() {
        return this.azL;
    }

    public void bx(boolean z) {
        this.azL = z;
    }
}
