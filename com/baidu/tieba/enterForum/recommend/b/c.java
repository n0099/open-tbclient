package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iMc = BdUniqueId.gen();
    public b iMd;
    public b iMe;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iMc;
    }

    public void a(b bVar) {
        this.iMe = bVar;
    }

    public void b(b bVar) {
        this.iMd = bVar;
    }
}
