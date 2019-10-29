package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWM = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b eWN;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.eWN = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bcz() {
        return this.eWN;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWM;
    }
}
