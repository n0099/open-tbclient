package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iMq = BdUniqueId.gen();
    public b iMr;
    public b iMs;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iMq;
    }

    public void a(b bVar) {
        this.iMs = bVar;
    }

    public void b(b bVar) {
        this.iMr = bVar;
    }
}
