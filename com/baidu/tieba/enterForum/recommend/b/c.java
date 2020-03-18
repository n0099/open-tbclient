package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fXQ = BdUniqueId.gen();
    public b fXR;
    public b fXS;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fXQ;
    }

    public void a(b bVar) {
        this.fXS = bVar;
    }

    public void b(b bVar) {
        this.fXR = bVar;
    }
}
