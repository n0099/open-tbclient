package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId clt = BdUniqueId.gen();
    private long clu;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return clt;
    }

    public long age() {
        return this.clu;
    }

    public void bh(long j) {
        this.clu = j;
    }
}
