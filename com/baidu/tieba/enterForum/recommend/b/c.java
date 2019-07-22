package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eZr = BdUniqueId.gen();
    public b eZs;
    public b eZt;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eZr;
    }

    public void a(b bVar) {
        this.eZt = bVar;
    }

    public void b(b bVar) {
        this.eZs = bVar;
    }
}
