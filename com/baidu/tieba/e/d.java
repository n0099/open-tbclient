package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQk = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b fQl;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.fQl = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bwC() {
        return this.fQl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQk;
    }
}
