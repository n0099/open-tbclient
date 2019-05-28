package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNj = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b eNk;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.eNk = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bbX() {
        return this.eNk;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNj;
    }
}
