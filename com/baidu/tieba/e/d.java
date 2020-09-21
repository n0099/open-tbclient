package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes21.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hxx = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b hxy;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.hxy = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b cgH() {
        return this.hxy;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hxx;
    }
}
