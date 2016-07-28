package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bk implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bFI = BdUniqueId.gen();
    private int height = 0;
    private int bFJ = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bFI;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.bFJ;
    }

    public void ho(int i) {
        this.bFJ = i;
    }
}
