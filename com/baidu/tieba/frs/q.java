package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cJL = BdUniqueId.gen();
    private long cJM;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJL;
    }

    public long amu() {
        return this.cJM;
    }

    public void bn(long j) {
        this.cJM = j;
    }
}
