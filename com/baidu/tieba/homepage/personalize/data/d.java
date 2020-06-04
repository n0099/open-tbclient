package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.m;
/* loaded from: classes9.dex */
public class d extends b {
    public static final BdUniqueId ifF = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return ifF;
    }

    public d() {
        setStType(m.aQj());
        setYuelaouLocate("percard#");
    }
}
