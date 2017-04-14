package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bl extends b {
    public static final BdUniqueId bPs = BdUniqueId.gen();
    private long bPt;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bPs;
    }

    public long aax() {
        return this.bPt;
    }

    public void aP(long j) {
        this.bPt = j;
    }
}
