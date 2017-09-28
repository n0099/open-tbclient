package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId csP = BdUniqueId.gen();
    private long csQ;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return csP;
    }

    public long ahY() {
        return this.csQ;
    }

    public void be(long j) {
        this.csQ = j;
    }
}
