package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bv;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId hTh = BdUniqueId.gen();
    private bv dLK;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hTh;
    }

    public bv aTN() {
        return this.dLK;
    }

    public void setThreadData(bv bvVar) {
        this.dLK = bvVar;
    }
}
