package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class au implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bHc = BdUniqueId.gen();
    private int height = 0;
    private int beA = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bHc;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.beA;
    }

    public void hQ(int i) {
        this.beA = i;
    }
}
