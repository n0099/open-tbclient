package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eVV = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b eVW;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.eVW = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bcx() {
        return this.eVW;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVV;
    }
}
