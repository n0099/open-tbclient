package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dkb = BdUniqueId.gen();
    private long dkc;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkb;
    }

    public long getReadTime() {
        return this.dkc;
    }

    public void setReadTime(long j) {
        this.dkc = j;
    }
}
