package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dOi = BdUniqueId.gen();
    private long dOj;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dOi;
    }

    public long aDn() {
        return this.dOj;
    }

    public void bZ(long j) {
        this.dOj = j;
    }
}
