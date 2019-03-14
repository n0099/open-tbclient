package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eEJ = BdUniqueId.gen();
    public b eEK;
    public b eEL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eEJ;
    }

    public void a(b bVar) {
        this.eEL = bVar;
    }

    public void b(b bVar) {
        this.eEK = bVar;
    }
}
