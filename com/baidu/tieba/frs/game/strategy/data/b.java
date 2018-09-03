package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.bb;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.data.b implements h {
    public static final BdUniqueId dwI = BdUniqueId.gen();
    private bb threadData;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dwI;
    }

    public bb Tg() {
        return this.threadData;
    }

    public void Z(bb bbVar) {
        this.threadData = bbVar;
    }
}
