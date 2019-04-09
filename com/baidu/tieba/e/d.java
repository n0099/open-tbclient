package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exF = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b exG;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.exG = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b aUM() {
        return this.exG;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exF;
    }
}
