package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId gxJ = BdUniqueId.gen();
    private bj cNb;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gxJ;
    }

    public bj axQ() {
        return this.cNb;
    }

    public void setThreadData(bj bjVar) {
        this.cNb = bjVar;
    }
}
