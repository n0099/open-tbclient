package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iGt = BdUniqueId.gen();
    public b iGu;
    public b iGv;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iGt;
    }

    public void a(b bVar) {
        this.iGv = bVar;
    }

    public void b(b bVar) {
        this.iGu = bVar;
    }
}
