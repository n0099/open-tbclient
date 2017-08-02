package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.f {
    public static final BdUniqueId cjJ = BdUniqueId.gen();
    private int cjK;

    public int afU() {
        return this.cjK;
    }

    public void iI(int i) {
        this.cjK = i;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cjJ;
    }
}
