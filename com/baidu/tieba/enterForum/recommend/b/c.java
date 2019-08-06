package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eZF = BdUniqueId.gen();
    public b eZG;
    public b eZH;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eZF;
    }

    public void a(b bVar) {
        this.eZH = bVar;
    }

    public void b(b bVar) {
        this.eZG = bVar;
    }
}
