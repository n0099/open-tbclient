package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEu = BdUniqueId.gen();
    public b eEv;
    public b eEw;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEu;
    }

    public void a(b bVar) {
        this.eEw = bVar;
    }

    public void b(b bVar) {
        this.eEv = bVar;
    }
}
