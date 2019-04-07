package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exE = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b exF;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.exF = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b aUM() {
        return this.exF;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exE;
    }
}
