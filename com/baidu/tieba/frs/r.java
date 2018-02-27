package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dGH = BdUniqueId.gen();
    private long dGI;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dGH;
    }

    public long awh() {
        return this.dGI;
    }

    public void bE(long j) {
        this.dGI = j;
    }
}
