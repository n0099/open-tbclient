package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cEa = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b cEb;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.cEb = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ajw() {
        return this.cEb;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEa;
    }
}
