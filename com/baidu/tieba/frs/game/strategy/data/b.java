package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bj;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId gzX = BdUniqueId.gen();
    private bj cRg;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gzX;
    }

    public bj aAg() {
        return this.cRg;
    }

    public void setThreadData(bj bjVar) {
        this.cRg = bjVar;
    }
}
