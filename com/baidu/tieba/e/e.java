package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOb = BdUniqueId.gen();
    private FeatureCardHot cOc;

    public void a(FeatureCardHot featureCardHot) {
        this.cOc = featureCardHot;
    }

    public FeatureCardHot anu() {
        return this.cOc;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOb;
    }
}
