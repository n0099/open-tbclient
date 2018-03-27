package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b implements i {
    public static final BdUniqueId dNQ = BdUniqueId.gen();
    private bd threadData;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dNQ;
    }

    public bd WE() {
        return this.threadData;
    }

    public void T(bd bdVar) {
        this.threadData = bdVar;
    }
}
