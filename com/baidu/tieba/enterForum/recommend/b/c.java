package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fdW = BdUniqueId.gen();
    public b fdX;
    public b fdY;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fdW;
    }

    public void a(b bVar) {
        this.fdY = bVar;
    }

    public void b(b bVar) {
        this.fdX = bVar;
    }
}
