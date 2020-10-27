package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ihg = BdUniqueId.gen();
    public b ihh;
    public b ihi;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ihg;
    }

    public void a(b bVar) {
        this.ihi = bVar;
    }

    public void b(b bVar) {
        this.ihh = bVar;
    }
}
