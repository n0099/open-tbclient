package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dyU = BdUniqueId.gen();
    private long dyV;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dyU;
    }

    public long auc() {
        return this.dyV;
    }

    public void bw(long j) {
        this.dyV = j;
    }
}
