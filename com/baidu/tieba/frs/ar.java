package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class ar implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bTr = BdUniqueId.gen();
    private int height = 0;
    private int bTs = 0;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bTr;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getBgResId() {
        return this.bTs;
    }

    public void hU(int i) {
        this.bTs = i;
    }
}
