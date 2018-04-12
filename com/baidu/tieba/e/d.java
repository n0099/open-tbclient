package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cEd = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b cEe;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.cEe = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ajw() {
        return this.cEe;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEd;
    }
}
