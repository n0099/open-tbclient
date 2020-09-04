package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqs = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b hqt;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.hqt = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b cds() {
        return this.hqt;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqs;
    }
}
