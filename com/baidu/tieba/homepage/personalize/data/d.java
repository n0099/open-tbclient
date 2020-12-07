package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.n;
/* loaded from: classes22.dex */
public class d extends b {
    public static final BdUniqueId jUy = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jUy;
    }

    public d() {
        setStType(n.boB());
        setYuelaouLocate("percard#");
    }
}
