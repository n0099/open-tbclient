package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQx = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b fQy;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.fQy = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bwD() {
        return this.fQy;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQx;
    }
}
