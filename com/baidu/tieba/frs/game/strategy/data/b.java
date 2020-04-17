package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId hkr = BdUniqueId.gen();
    private bj dqA;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hkr;
    }

    public bj aIw() {
        return this.dqA;
    }

    public void setThreadData(bj bjVar) {
        this.dqA = bjVar;
    }
}
