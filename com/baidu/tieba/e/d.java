package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqm = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b hqn;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.hqn = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b cdr() {
        return this.hqn;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqm;
    }
}
