package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId cyW = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cyW;
    }

    public d() {
        setStType(at.Mt());
        setYuelaouLocate("percard#");
    }
}
