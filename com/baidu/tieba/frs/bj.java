package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bj extends b {
    public static final BdUniqueId bPD = BdUniqueId.gen();
    private long bPE;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bPD;
    }

    public long ZZ() {
        return this.bPE;
    }

    public void aP(long j) {
        this.bPE = j;
    }
}
