package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId ihp = BdUniqueId.gen();
    private bw dUS;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ihp;
    }

    public bw bce() {
        return this.dUS;
    }

    public void setThreadData(bw bwVar) {
        this.dUS = bwVar;
    }
}
