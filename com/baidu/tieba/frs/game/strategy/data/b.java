package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class b extends BaseCardInfo implements n {
    public static final BdUniqueId jxv = BdUniqueId.gen();
    private cb eJQ;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jxv;
    }

    public cb bln() {
        return this.eJQ;
    }

    public void setThreadData(cb cbVar) {
        this.eJQ = cbVar;
    }
}
