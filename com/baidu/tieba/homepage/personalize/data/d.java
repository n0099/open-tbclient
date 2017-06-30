package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId cKH = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cKH;
    }

    public d() {
        setStType(at.ri());
        setYuelaouLocate("percard#");
    }
}
