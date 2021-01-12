package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.m;
/* loaded from: classes2.dex */
public class d extends b {
    public static final BdUniqueId kdf = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.i, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return kdf;
    }

    public d() {
        setStType(m.bnj());
        setYuelaouLocate("percard#");
    }
}
