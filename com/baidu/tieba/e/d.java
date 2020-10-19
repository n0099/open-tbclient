package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hMs = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b hMt;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.hMt = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ckd() {
        return this.hMt;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hMs;
    }
}
