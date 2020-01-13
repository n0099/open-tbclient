package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes7.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fUS = BdUniqueId.gen();
    public b fUT;
    public b fUU;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fUS;
    }

    public void a(b bVar) {
        this.fUU = bVar;
    }

    public void b(b bVar) {
        this.fUT = bVar;
    }
}
