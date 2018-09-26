package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId duV = BdUniqueId.gen();
    private long duW;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return duV;
    }

    public long axy() {
        return this.duW;
    }

    public void bK(long j) {
        this.duW = j;
    }
}
