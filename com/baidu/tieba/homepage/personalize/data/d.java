package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.o;
/* loaded from: classes6.dex */
public class d extends b {
    public static final BdUniqueId eoy = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eoy;
    }

    public d() {
        setStType(o.yj());
        setYuelaouLocate("percard#");
    }
}
