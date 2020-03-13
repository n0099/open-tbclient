package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fXi = BdUniqueId.gen();
    public b fXj;
    public b fXk;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fXi;
    }

    public void a(b bVar) {
        this.fXk = bVar;
    }

    public void b(b bVar) {
        this.fXj = bVar;
    }
}
