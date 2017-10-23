package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId csD = BdUniqueId.gen();
    private long csE;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return csD;
    }

    public long ahT() {
        return this.csE;
    }

    public void bf(long j) {
        this.csE = j;
    }
}
