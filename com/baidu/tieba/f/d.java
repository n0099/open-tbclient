package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iqB = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b iqC;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.iqC = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b ctD() {
        return this.iqC;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqB;
    }
}
