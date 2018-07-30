package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class i implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dma = BdUniqueId.gen();
    private int height = 0;
    private int dmb = 0;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dma;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int auc() {
        return this.dmb;
    }

    public void kq(int i) {
        this.dmb = i;
    }
}
