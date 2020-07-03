package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.bu;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.data.b implements q {
    public static final BdUniqueId hNg = BdUniqueId.gen();
    private bu dLi;

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hNg;
    }

    public bu aPS() {
        return this.dLi;
    }

    public void setThreadData(bu buVar) {
        this.dLi = buVar;
    }
}
