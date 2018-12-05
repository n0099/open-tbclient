package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dKL = BdUniqueId.gen();
    private long dKM;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dKL;
    }

    public long aCb() {
        return this.dKM;
    }

    public void bU(long j) {
        this.dKM = j;
    }
}
