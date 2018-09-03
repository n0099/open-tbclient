package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOz = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b cOA;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.cOA = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ano() {
        return this.cOA;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOz;
    }
}
