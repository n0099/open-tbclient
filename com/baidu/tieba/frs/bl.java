package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bl extends b {
    public static final BdUniqueId bRJ = BdUniqueId.gen();
    private long bRK;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bRJ;
    }

    public long aby() {
        return this.bRK;
    }

    public void aP(long j) {
        this.bRK = j;
    }
}
