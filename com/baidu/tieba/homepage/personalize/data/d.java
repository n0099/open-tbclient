package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.k;
/* loaded from: classes2.dex */
public class d extends b {
    public static final BdUniqueId efQ = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return efQ;
    }

    public d() {
        setStType(k.yI());
        setYuelaouLocate("percard#");
    }
}
