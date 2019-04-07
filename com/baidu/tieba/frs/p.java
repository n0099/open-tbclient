package com.baidu.tieba.frs;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class p extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fbL = BdUniqueId.gen();
    private long fbM;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbL;
    }

    public void cE(long j) {
        this.fbM = j;
    }
}
