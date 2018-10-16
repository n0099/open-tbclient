package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dcI = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b dcJ;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.dcJ = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b asy() {
        return this.dcJ;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcI;
    }
}
