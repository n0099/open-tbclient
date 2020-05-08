package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gEA = BdUniqueId.gen();
    public b gEB;
    public b gEC;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gEA;
    }

    public void a(b bVar) {
        this.gEC = bVar;
    }

    public void b(b bVar) {
        this.gEB = bVar;
    }
}
