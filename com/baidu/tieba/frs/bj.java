package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bj extends b {
    public static final BdUniqueId bIu = BdUniqueId.gen();
    private long bIv;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bIu;
    }

    public long Za() {
        return this.bIv;
    }

    public void aP(long j) {
        this.bIv = j;
    }
}
