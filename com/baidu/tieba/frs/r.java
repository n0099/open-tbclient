package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dGT = BdUniqueId.gen();
    private long dGU;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGT;
    }

    public long awi() {
        return this.dGU;
    }

    public void bE(long j) {
        this.dGU = j;
    }
}
