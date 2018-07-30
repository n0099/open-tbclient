package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dpa = BdUniqueId.gen();
    private long dpb;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dpa;
    }

    public long avF() {
        return this.dpb;
    }

    public void bG(long j) {
        this.dpb = j;
    }
}
