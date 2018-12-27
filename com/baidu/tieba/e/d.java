package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dnm = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b dnn;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.dnn = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b auz() {
        return this.dnn;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dnm;
    }
}
