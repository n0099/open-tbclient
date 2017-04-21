package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId axX = BdUniqueId.gen();
    private String axY;
    private String axZ;
    private boolean aya = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return axX;
    }

    public String CP() {
        return this.axY;
    }

    public void eX(String str) {
        this.axY = str;
    }

    public String getSmallUrl() {
        return this.axZ;
    }

    public void eY(String str) {
        this.axZ = str;
    }

    public boolean CQ() {
        return this.aya;
    }

    public void bw(boolean z) {
        this.aya = z;
    }
}
