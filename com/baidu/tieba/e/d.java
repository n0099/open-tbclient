package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dkw = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b dkx;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.dkx = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b atK() {
        return this.dkx;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkw;
    }
}
