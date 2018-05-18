package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cFj = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b cFk;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.cFk = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ajw() {
        return this.cFk;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cFj;
    }
}
