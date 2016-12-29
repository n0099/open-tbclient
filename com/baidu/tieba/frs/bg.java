package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bg implements com.baidu.adp.widget.ListView.v {
    public static final BdUniqueId bAx = BdUniqueId.gen();
    private int bAy;

    public int XQ() {
        return this.bAy;
    }

    public void hi(int i) {
        this.bAy = i;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bAx;
    }
}
