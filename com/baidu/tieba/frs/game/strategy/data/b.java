package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bg;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId fFf = BdUniqueId.gen();
    private bg threadData;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fFf;
    }

    public bg acx() {
        return this.threadData;
    }

    public void ai(bg bgVar) {
        this.threadData = bgVar;
    }
}
