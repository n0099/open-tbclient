package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId guz = BdUniqueId.gen();
    private bj cMR;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return guz;
    }

    public bj axx() {
        return this.cMR;
    }

    public void setThreadData(bj bjVar) {
        this.cMR = bjVar;
    }
}
