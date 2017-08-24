package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.m;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId cWF = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cWF;
    }

    public d() {
        setStType(m.rx());
        setYuelaouLocate("percard#");
    }
}
