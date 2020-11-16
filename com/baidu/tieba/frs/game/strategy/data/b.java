package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class b extends BaseCardInfo implements q {
    public static final BdUniqueId iWv = BdUniqueId.gen();
    private bx evQ;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iWv;
    }

    public bx bjd() {
        return this.evQ;
    }

    public void setThreadData(bx bxVar) {
        this.evQ = bxVar;
    }
}
