package com.baidu.tbadk.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public class k implements v {
    public static final BdUniqueId axV = BdUniqueId.gen();
    private String axW;
    private String axX;
    private boolean axY = false;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return axV;
    }

    public String CP() {
        return this.axW;
    }

    public void eX(String str) {
        this.axW = str;
    }

    public String getSmallUrl() {
        return this.axX;
    }

    public void eY(String str) {
        this.axX = str;
    }

    public boolean CQ() {
        return this.axY;
    }

    public void bw(boolean z) {
        this.axY = z;
    }
}
