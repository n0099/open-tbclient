package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gvO = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b gvP;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.gvP = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bGu() {
        return this.gvP;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvO;
    }
}
