package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bg extends b {
    public static final BdUniqueId bWr = BdUniqueId.gen();
    private long bWs;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bWr;
    }

    public long abc() {
        return this.bWs;
    }

    public void aR(long j) {
        this.bWs = j;
    }
}
