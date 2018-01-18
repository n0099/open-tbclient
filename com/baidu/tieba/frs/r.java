package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class r extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dDv = BdUniqueId.gen();
    private long dDw;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dDv;
    }

    public long avf() {
        return this.dDw;
    }

    public void bB(long j) {
        this.dDw = j;
    }
}
