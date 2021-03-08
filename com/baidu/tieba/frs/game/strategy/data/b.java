package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class b extends BaseCardInfo implements n {
    public static final BdUniqueId jzs = BdUniqueId.gen();
    private cb eLr;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jzs;
    }

    public cb blp() {
        return this.eLr;
    }

    public void setThreadData(cb cbVar) {
        this.eLr = cbVar;
    }
}
