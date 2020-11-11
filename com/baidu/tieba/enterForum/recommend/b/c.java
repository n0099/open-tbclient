package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ine = BdUniqueId.gen();
    public b inf;
    public b ing;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ine;
    }

    public void a(b bVar) {
        this.ing = bVar;
    }

    public void b(b bVar) {
        this.inf = bVar;
    }
}
