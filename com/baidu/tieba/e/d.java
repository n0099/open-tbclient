package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hds = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b hdt;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.hdt = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bTf() {
        return this.hdt;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hds;
    }
}
