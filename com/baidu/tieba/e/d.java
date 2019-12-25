package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fKE = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b fKF;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.fKF = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b btU() {
        return this.fKF;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKE;
    }
}
