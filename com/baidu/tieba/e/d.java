package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iyo = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b iyp;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.iyp = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b csF() {
        return this.iyp;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iyo;
    }
}
