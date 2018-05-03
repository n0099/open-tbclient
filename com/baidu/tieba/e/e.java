package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cEc = BdUniqueId.gen();
    private FeatureCardHot cEd;

    public void a(FeatureCardHot featureCardHot) {
        this.cEd = featureCardHot;
    }

    public FeatureCardHot ajx() {
        return this.cEd;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEc;
    }
}
