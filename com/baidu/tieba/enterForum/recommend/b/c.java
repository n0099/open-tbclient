package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hFL = BdUniqueId.gen();
    public b hFM;
    public b hFN;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hFL;
    }

    public void a(b bVar) {
        this.hFN = bVar;
    }

    public void b(b bVar) {
        this.hFM = bVar;
    }
}
