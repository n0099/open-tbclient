package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class d extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gKF = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b gKG;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.gKG = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b bMM() {
        return this.gKG;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKF;
    }
}
