package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hgc = BdUniqueId.gen();
    public b hgd;
    public b hge;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hgc;
    }

    public void a(b bVar) {
        this.hge = bVar;
    }

    public void b(b bVar) {
        this.hgd = bVar;
    }
}
