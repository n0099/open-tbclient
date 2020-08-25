package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hSy = BdUniqueId.gen();
    private int height = 0;
    private int hSz = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hSy;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int clI() {
        return this.hSz;
    }

    public void wQ(int i) {
        this.hSz = i;
    }
}
