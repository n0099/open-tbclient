package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dEm = BdUniqueId.gen();
    private long dEn;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dEm;
    }

    public long aAr() {
        return this.dEn;
    }

    public void bN(long j) {
        this.dEn = j;
    }
}
