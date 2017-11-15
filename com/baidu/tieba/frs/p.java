package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cAt = BdUniqueId.gen();
    private long cAu;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cAt;
    }

    public long akp() {
        return this.cAu;
    }

    public void bf(long j) {
        this.cAu = j;
    }
}
