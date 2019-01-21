package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dOj = BdUniqueId.gen();
    private long dOk;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dOj;
    }

    public long aDn() {
        return this.dOk;
    }

    public void bZ(long j) {
        this.dOk = j;
    }
}
