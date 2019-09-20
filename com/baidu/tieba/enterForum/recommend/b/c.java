package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fbl = BdUniqueId.gen();
    public b fbm;
    public b fbn;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fbl;
    }

    public void a(b bVar) {
        this.fbn = bVar;
    }

    public void b(b bVar) {
        this.fbm = bVar;
    }
}
