package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.o;
/* loaded from: classes2.dex */
public class d extends b {
    public static final BdUniqueId dRz = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dRz;
    }

    public d() {
        setStType(o.vb());
        setYuelaouLocate("percard#");
    }
}
