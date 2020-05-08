package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gvU = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b gvV;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.gvV = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bGs() {
        return this.gvV;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvU;
    }
}
