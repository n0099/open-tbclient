package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gEu = BdUniqueId.gen();
    public b gEv;
    public b gEw;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gEu;
    }

    public void a(b bVar) {
        this.gEw = bVar;
    }

    public void b(b bVar) {
        this.gEv = bVar;
    }
}
