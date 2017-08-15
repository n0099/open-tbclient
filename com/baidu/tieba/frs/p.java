package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cmf = BdUniqueId.gen();
    private long cmg;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cmf;
    }

    public long agz() {
        return this.cmg;
    }

    public void bh(long j) {
        this.cmg = j;
    }
}
