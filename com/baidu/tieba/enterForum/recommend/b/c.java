package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eUp = BdUniqueId.gen();
    public b eUq;
    public b eUr;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eUp;
    }

    public void a(b bVar) {
        this.eUr = bVar;
    }

    public void b(b bVar) {
        this.eUq = bVar;
    }
}
