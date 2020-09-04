package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hyJ = BdUniqueId.gen();
    public b hyK;
    public b hyL;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hyJ;
    }

    public void a(b bVar) {
        this.hyL = bVar;
    }

    public void b(b bVar) {
        this.hyK = bVar;
    }
}
