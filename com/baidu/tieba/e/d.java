package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eSq = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b eSr;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.eSr = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bea() {
        return this.eSr;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSq;
    }
}
