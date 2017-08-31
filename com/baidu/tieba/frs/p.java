package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId crA = BdUniqueId.gen();
    private long crB;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return crA;
    }

    public long ahR() {
        return this.crB;
    }

    public void bh(long j) {
        this.crB = j;
    }
}
