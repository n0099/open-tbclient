package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bh extends b {
    public static final BdUniqueId cez = BdUniqueId.gen();
    private long ceA;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cez;
    }

    public long aeT() {
        return this.ceA;
    }

    public void bf(long j) {
        this.ceA = j;
    }
}
