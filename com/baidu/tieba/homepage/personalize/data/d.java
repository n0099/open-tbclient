package com.baidu.tieba.homepage.personalize.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.k;
/* loaded from: classes.dex */
public class d extends b {
    public static final BdUniqueId drm = BdUniqueId.gen();

    @Override // com.baidu.tieba.card.data.g, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return drm;
    }

    public d() {
        setStType(k.rn());
        setYuelaouLocate("percard#");
    }
}
