package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.m;
/* loaded from: classes16.dex */
public class d extends b {
    public static final BdUniqueId iAU = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iAU;
    }

    public d() {
        setStType(m.aVX());
        setYuelaouLocate("percard#");
    }
}
