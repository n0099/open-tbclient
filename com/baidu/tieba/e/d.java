package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes3.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOC = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b cOD;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.cOD = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b anm() {
        return this.cOD;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOC;
    }
}
