package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fNN = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b fNO;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.fNO = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b buW() {
        return this.fNO;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNN;
    }
}
