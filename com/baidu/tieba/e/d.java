package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQi = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b fQj;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.fQj = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bwA() {
        return this.fQj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQi;
    }
}
