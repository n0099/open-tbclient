package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dnZ = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b doa;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.doa = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b auX() {
        return this.doa;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnZ;
    }
}
