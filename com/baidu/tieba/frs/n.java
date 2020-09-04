package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class n implements com.baidu.adp.widget.ListView.q {
    public static final BdUniqueId hSE = BdUniqueId.gen();
    private int height = 0;
    private int hSF = 0;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hSE;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int clJ() {
        return this.hSF;
    }

    public void wQ(int i) {
        this.hSF = i;
    }
}
