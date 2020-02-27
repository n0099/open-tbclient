package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fWT = BdUniqueId.gen();
    public b fWU;
    public b fWV;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fWT;
    }

    public void a(b bVar) {
        this.fWV = bVar;
    }

    public void b(b bVar) {
        this.fWU = bVar;
    }
}
