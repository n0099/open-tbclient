package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.j;
/* loaded from: classes2.dex */
public class d extends b {
    public static final BdUniqueId ekx = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return ekx;
    }

    public d() {
        setStType(j.zd());
        setYuelaouLocate("percard#");
    }
}
