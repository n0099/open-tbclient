package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class b extends BaseCardInfo implements n {
    public static final BdUniqueId jwv = BdUniqueId.gen();
    private bz eMv;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jwv;
    }

    public bz boP() {
        return this.eMv;
    }

    public void setThreadData(bz bzVar) {
        this.eMv = bzVar;
    }
}
