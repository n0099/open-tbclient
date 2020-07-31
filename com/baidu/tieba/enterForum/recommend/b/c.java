package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes16.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hlM = BdUniqueId.gen();
    public b hlN;
    public b hlO;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hlM;
    }

    public void a(b bVar) {
        this.hlO = bVar;
    }

    public void b(b bVar) {
        this.hlN = bVar;
    }
}
