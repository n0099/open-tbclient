package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dNz = BdUniqueId.gen();
    private long dNA;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dNz;
    }

    public long aCQ() {
        return this.dNA;
    }

    public void bZ(long j) {
        this.dNA = j;
    }
}
