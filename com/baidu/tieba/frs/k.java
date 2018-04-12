package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cZA = BdUniqueId.gen();
    private int cZB;

    public int aqC() {
        return this.cZB;
    }

    public void kk(int i) {
        this.cZB = i;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cZA;
    }
}
