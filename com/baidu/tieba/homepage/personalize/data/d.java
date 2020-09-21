package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.m;
/* loaded from: classes21.dex */
public class d extends b {
    public static final BdUniqueId iYA = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.j, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iYA;
    }

    public d() {
        setStType(m.bfk());
        setYuelaouLocate("percard#");
    }
}
