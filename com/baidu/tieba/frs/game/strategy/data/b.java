package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId fFT = BdUniqueId.gen();
    private bh threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fFT;
    }

    public bh acy() {
        return this.threadData;
    }

    public void aj(bh bhVar) {
        this.threadData = bhVar;
    }
}
