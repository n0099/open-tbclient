package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.k;
/* loaded from: classes2.dex */
public class d extends b {
    public static final BdUniqueId eeB = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return eeB;
    }

    public d() {
        setStType(k.yN());
        setYuelaouLocate("percard#");
    }
}
