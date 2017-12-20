package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cJH = BdUniqueId.gen();
    private long cJI;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJH;
    }

    public long amt() {
        return this.cJI;
    }

    public void bn(long j) {
        this.cJI = j;
    }
}
