package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class bl extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId bBa = BdUniqueId.gen();
    private long bBb;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bBa;
    }

    public long XT() {
        return this.bBb;
    }

    public void aT(long j) {
        this.bBb = j;
    }
}
