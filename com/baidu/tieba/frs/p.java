package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dmi = BdUniqueId.gen();
    private long dmj;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dmi;
    }

    public long getReadTime() {
        return this.dmj;
    }

    public void setReadTime(long j) {
        this.dmj = j;
    }
}
