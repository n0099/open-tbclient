package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class l implements v {
    public static final BdUniqueId atB = BdUniqueId.gen();
    private String SX;
    private String SY;
    private boolean atC = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return atB;
    }

    public String Cp() {
        return this.SY;
    }

    public void fj(String str) {
        this.SY = str;
    }

    public String getSmallUrl() {
        return this.SX;
    }

    public void fk(String str) {
        this.SX = str;
    }

    public boolean Cq() {
        return this.atC;
    }

    public void bv(boolean z) {
        this.atC = z;
    }
}
