package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDQ = BdUniqueId.gen();
    private long dDR;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDQ;
    }

    public long avk() {
        return this.dDR;
    }

    public void bD(long j) {
        this.dDR = j;
    }
}
