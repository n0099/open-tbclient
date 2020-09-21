package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId iox = BdUniqueId.gen();
    private bw dXg;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iox;
    }

    public bw bcY() {
        return this.dXg;
    }

    public void setThreadData(bw bwVar) {
        this.dXg = bwVar;
    }
}
