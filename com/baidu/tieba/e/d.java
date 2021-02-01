package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iDY = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b iDZ;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.iDZ = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ctR() {
        return this.iDZ;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iDY;
    }
}
