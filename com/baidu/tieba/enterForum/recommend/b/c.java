package com.baidu.tieba.enterForum.recommend.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId iyN = BdUniqueId.gen();
    public b iyO;
    public b iyP;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iyN;
    }

    public void a(b bVar) {
        this.iyP = bVar;
    }

    public void b(b bVar) {
        this.iyO = bVar;
    }
}
