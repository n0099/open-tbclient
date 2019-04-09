package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEv = BdUniqueId.gen();
    public b eEw;
    public b eEx;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEv;
    }

    public void a(b bVar) {
        this.eEx = bVar;
    }

    public void b(b bVar) {
        this.eEw = bVar;
    }
}
