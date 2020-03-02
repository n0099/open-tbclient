package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fWV = BdUniqueId.gen();
    public b fWW;
    public b fWX;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fWV;
    }

    public void a(b bVar) {
        this.fWX = bVar;
    }

    public void b(b bVar) {
        this.fWW = bVar;
    }
}
