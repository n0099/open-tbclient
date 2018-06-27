package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cLT = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b cLU;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.cLU = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b amN() {
        return this.cLU;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cLT;
    }
}
