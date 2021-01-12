package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class b extends BaseCardInfo implements n {
    public static final BdUniqueId jrP = BdUniqueId.gen();
    private bz eHK;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jrP;
    }

    public bz bkV() {
        return this.eHK;
    }

    public void setThreadData(bz bzVar) {
        this.eHK = bzVar;
    }
}
