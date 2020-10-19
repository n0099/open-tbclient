package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId iDq = BdUniqueId.gen();
    private bw eji;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iDq;
    }

    public bw bfG() {
        return this.eji;
    }

    public void setThreadData(bw bwVar) {
        this.eji = bwVar;
    }
}
