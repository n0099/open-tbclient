package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dCW = BdUniqueId.gen();
    private long dCX;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dCW;
    }

    public long aAT() {
        return this.dCX;
    }

    public void bR(long j) {
        this.dCX = j;
    }
}
