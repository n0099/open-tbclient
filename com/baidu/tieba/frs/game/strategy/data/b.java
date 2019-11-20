package com.baidu.tieba.frs.game.strategy.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bh;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.data.b implements m {
    public static final BdUniqueId fGg = BdUniqueId.gen();
    private bh caz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fGg;
    }

    public bh agG() {
        return this.caz;
    }

    public void ai(bh bhVar) {
        this.caz = bhVar;
    }
}
