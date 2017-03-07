package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId cAs = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cAs;
    }

    public d() {
        setStType(at.rH());
        setYuelaouLocate("percard#");
    }
}
