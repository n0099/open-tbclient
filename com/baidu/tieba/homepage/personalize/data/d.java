package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.ap;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId cwq = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cwq;
    }

    public d() {
        setStType(ap.rp());
        setYuelaouLocate("percard#");
    }
}
