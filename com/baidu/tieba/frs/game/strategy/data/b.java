package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId fHI = BdUniqueId.gen();
    private bh threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fHI;
    }

    public bh acC() {
        return this.threadData;
    }

    public void ak(bh bhVar) {
        this.threadData = bhVar;
    }
}
