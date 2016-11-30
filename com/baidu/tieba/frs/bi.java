package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bi extends b {
    public static final BdUniqueId bUO = BdUniqueId.gen();
    private long bUP;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bUO;
    }

    public long adA() {
        return this.bUP;
    }

    public void bg(long j) {
        this.bUP = j;
    }
}
