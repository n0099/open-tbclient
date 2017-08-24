package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cmg = BdUniqueId.gen();
    private long cmh;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cmg;
    }

    public long agt() {
        return this.cmh;
    }

    public void bh(long j) {
        this.cmh = j;
    }
}
