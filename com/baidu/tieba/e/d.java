package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gXN = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b gXO;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.gXO = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bPU() {
        return this.gXO;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gXN;
    }
}
