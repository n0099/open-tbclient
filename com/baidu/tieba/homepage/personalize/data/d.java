package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.m;
/* loaded from: classes9.dex */
public class d extends b {
    public static final BdUniqueId iuQ = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iuQ;
    }

    public d() {
        setStType(m.aSb());
        setYuelaouLocate("percard#");
    }
}
