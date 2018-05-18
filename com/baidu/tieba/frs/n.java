package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes2.dex */
public class n extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId daL = BdUniqueId.gen();
    private long daM;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return daL;
    }

    public long getReadTime() {
        return this.daM;
    }

    public void setReadTime(long j) {
        this.daM = j;
    }
}
