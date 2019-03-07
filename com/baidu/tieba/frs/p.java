package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fbZ = BdUniqueId.gen();
    private long fca;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbZ;
    }

    public void cE(long j) {
        this.fca = j;
    }
}
