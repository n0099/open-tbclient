package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dGM = BdUniqueId.gen();
    private long dGN;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGM;
    }

    public long awj() {
        return this.dGN;
    }

    public void bE(long j) {
        this.dGN = j;
    }
}
