package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hUG = BdUniqueId.gen();
    public b hUH;
    public b hUI;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hUG;
    }

    public void a(b bVar) {
        this.hUI = bVar;
    }

    public void b(b bVar) {
        this.hUH = bVar;
    }
}
