package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNi = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b eNj;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.eNj = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bbU() {
        return this.eNj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNi;
    }
}
