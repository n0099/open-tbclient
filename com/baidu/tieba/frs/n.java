package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cZF = BdUniqueId.gen();
    private long cZG;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cZF;
    }

    public long getReadTime() {
        return this.cZG;
    }

    public void setReadTime(long j) {
        this.cZG = j;
    }
}
