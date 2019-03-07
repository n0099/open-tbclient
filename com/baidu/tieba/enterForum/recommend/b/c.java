package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEN = BdUniqueId.gen();
    public b eEO;
    public b eEP;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEN;
    }

    public void a(b bVar) {
        this.eEP = bVar;
    }

    public void b(b bVar) {
        this.eEO = bVar;
    }
}
