package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdf = BdUniqueId.gen();
    public b fdg;
    public b fdh;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdf;
    }

    public void a(b bVar) {
        this.fdh = bVar;
    }

    public void b(b bVar) {
        this.fdg = bVar;
    }
}
