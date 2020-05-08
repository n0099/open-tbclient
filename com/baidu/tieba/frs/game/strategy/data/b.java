package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId hkx = BdUniqueId.gen();
    private bj dqE;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hkx;
    }

    public bj aIu() {
        return this.dqE;
    }

    public void setThreadData(bj bjVar) {
        this.dqE = bjVar;
    }
}
