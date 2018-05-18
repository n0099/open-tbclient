package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bd;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dhA = BdUniqueId.gen();
    private bd threadData;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dhA;
    }

    public bd Pb() {
        return this.threadData;
    }

    public void T(bd bdVar) {
        this.threadData = bdVar;
    }
}
