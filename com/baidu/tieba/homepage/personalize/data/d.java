package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class d extends b {
    public static final BdUniqueId knF = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return knF;
    }

    public d() {
        setStType(m.bnE());
        setYuelaouLocate("percard#");
    }
}
