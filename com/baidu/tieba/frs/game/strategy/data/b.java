package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class b extends BaseCardInfo implements q {
    public static final BdUniqueId jjU = BdUniqueId.gen();
    private by eCR;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jjU;
    }

    public by bmn() {
        return this.eCR;
    }

    public void setThreadData(by byVar) {
        this.eCR = byVar;
    }
}
