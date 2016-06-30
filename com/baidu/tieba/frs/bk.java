package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bk implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bEv = BdUniqueId.gen();
    private int height = 0;
    private int bEw = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bEv;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.bEw;
    }

    public void ho(int i) {
        this.bEw = i;
    }
}
