package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hYP = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b hYQ;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.hYQ = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b cnk() {
        return this.hYQ;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYP;
    }
}
