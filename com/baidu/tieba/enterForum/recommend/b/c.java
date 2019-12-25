package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fRI = BdUniqueId.gen();
    public b fRJ;
    public b fRK;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRI;
    }

    public void a(b bVar) {
        this.fRK = bVar;
    }

    public void b(b bVar) {
        this.fRJ = bVar;
    }
}
