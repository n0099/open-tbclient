package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bc;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dtY = BdUniqueId.gen();
    private bc threadData;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dtY;
    }

    public bc SV() {
        return this.threadData;
    }

    public void X(bc bcVar) {
        this.threadData = bcVar;
    }
}
