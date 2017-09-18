package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId crQ = BdUniqueId.gen();
    private int crR;

    public int ahZ() {
        return this.crR;
    }

    public void iY(int i) {
        this.crR = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return crQ;
    }
}
