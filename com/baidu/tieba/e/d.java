package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exT = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b exU;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.exU = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b aUO() {
        return this.exU;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exT;
    }
}
