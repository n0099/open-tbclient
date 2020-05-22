package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gTi = BdUniqueId.gen();
    public b gTj;
    public b gTk;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gTi;
    }

    public void a(b bVar) {
        this.gTk = bVar;
    }

    public void b(b bVar) {
        this.gTj = bVar;
    }
}
