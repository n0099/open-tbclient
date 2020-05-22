package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.data.bk;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b implements o {
    public static final BdUniqueId hzl = BdUniqueId.gen();
    private bk dEA;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hzl;
    }

    public bk aOi() {
        return this.dEA;
    }

    public void setThreadData(bk bkVar) {
        this.dEA = bkVar;
    }
}
