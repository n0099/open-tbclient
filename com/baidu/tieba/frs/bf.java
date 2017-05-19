package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.b;
/* loaded from: classes.dex */
public class bf extends b {
    public static final BdUniqueId bQA = BdUniqueId.gen();
    private long bQB;

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return bQA;
    }

    public long aaa() {
        return this.bQB;
    }

    public void aO(long j) {
        this.bQB = j;
    }
}
