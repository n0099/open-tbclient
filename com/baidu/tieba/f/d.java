package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iqz = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b iqA;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.iqA = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ctC() {
        return this.iqA;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqz;
    }
}
