package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cAa = BdUniqueId.gen();
    private long cAb;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cAa;
    }

    public long akb() {
        return this.cAb;
    }

    public void bf(long j) {
        this.cAb = j;
    }
}
