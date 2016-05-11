package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bx implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId biz = BdUniqueId.gen();
    private int height = 0;
    private int biA = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return biz;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int Qu() {
        return this.biA;
    }

    public void go(int i) {
        this.biA = i;
    }
}
