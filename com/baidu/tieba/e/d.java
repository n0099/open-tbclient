package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cNZ = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b cOa;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.cOa = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ant() {
        return this.cOa;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cNZ;
    }
}
