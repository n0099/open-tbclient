package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cZC = BdUniqueId.gen();
    private long cZD;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cZC;
    }

    public long getReadTime() {
        return this.cZD;
    }

    public void setReadTime(long j) {
        this.cZD = j;
    }
}
