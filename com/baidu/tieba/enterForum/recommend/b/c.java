package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gTt = BdUniqueId.gen();
    public b gTu;
    public b gTv;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gTt;
    }

    public void a(b bVar) {
        this.gTv = bVar;
    }

    public void b(b bVar) {
        this.gTu = bVar;
    }
}
