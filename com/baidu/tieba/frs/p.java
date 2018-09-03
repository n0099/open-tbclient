package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId doY = BdUniqueId.gen();
    private long doZ;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return doY;
    }

    public long avE() {
        return this.doZ;
    }

    public void bG(long j) {
        this.doZ = j;
    }
}
