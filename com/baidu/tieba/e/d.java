package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ddO = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b ddP;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.ddP = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b arY() {
        return this.ddP;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ddO;
    }
}
