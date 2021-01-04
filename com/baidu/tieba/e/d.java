package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class d extends BaseCardInfo {
    public static final BdUniqueId iCV = BdUniqueId.gen();
    private com.baidu.tieba.frs.gamerecommend.data.b iCW;

    public void a(com.baidu.tieba.frs.gamerecommend.data.b bVar) {
        this.iCW = bVar;
    }

    public com.baidu.tieba.frs.gamerecommend.data.b cww() {
        return this.iCW;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iCV;
    }
}
