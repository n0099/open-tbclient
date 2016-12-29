package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.ap;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId crQ = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return crQ;
    }

    public d() {
        setStType(ap.OB());
        setYuelaouLocate("percard#");
    }
}
