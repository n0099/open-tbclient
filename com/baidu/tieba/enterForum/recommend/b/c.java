package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iNZ = BdUniqueId.gen();
    public b iOa;
    public b iOb;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iNZ;
    }

    public void a(b bVar) {
        this.iOb = bVar;
    }

    public void b(b bVar) {
        this.iOa = bVar;
    }
}
