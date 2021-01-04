package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iLa = BdUniqueId.gen();
    public b iLb;
    public b iLc;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iLa;
    }

    public void a(b bVar) {
        this.iLc = bVar;
    }

    public void b(b bVar) {
        this.iLb = bVar;
    }
}
