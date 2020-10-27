package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.n;
/* loaded from: classes22.dex */
public class d extends b {
    public static final BdUniqueId jzZ = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.j, com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jzZ;
    }

    public d() {
        setStType(n.bjM());
        setYuelaouLocate("percard#");
    }
}
