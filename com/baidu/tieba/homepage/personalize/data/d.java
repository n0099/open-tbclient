package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.o;
/* loaded from: classes2.dex */
public class d extends b {
    public static final BdUniqueId dVs = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dVs;
    }

    public d() {
        setStType(o.vk());
        setYuelaouLocate("percard#");
    }
}
