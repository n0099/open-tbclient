package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hyD = BdUniqueId.gen();
    public b hyE;
    public b hyF;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hyD;
    }

    public void a(b bVar) {
        this.hyF = bVar;
    }

    public void b(b bVar) {
        this.hyE = bVar;
    }
}
