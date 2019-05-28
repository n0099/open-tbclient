package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eUq = BdUniqueId.gen();
    public b eUr;
    public b eUs;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eUq;
    }

    public void a(b bVar) {
        this.eUs = bVar;
    }

    public void b(b bVar) {
        this.eUr = bVar;
    }
}
