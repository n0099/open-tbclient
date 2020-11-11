package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId iVJ = BdUniqueId.gen();
    private bw exA;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iVJ;
    }

    public bw bjZ() {
        return this.exA;
    }

    public void setThreadData(bw bwVar) {
        this.exA = bwVar;
    }
}
