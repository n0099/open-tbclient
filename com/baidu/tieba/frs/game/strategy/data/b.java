package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bw;
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId ihv = BdUniqueId.gen();
    private bw dUW;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ihv;
    }

    public bw bce() {
        return this.dUW;
    }

    public void setThreadData(bw bwVar) {
        this.dUW = bwVar;
    }
}
