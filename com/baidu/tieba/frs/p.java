package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cJx = BdUniqueId.gen();
    private long cJy;

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cJx;
    }

    public long aml() {
        return this.cJy;
    }

    public void bn(long j) {
        this.cJy = j;
    }
}
