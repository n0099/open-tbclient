package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.at;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId cCJ = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cCJ;
    }

    public d() {
        setStType(at.rl());
        setYuelaouLocate("percard#");
    }
}
