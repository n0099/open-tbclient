package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cEf = BdUniqueId.gen();
    private FeatureCardHot cEg;

    public void a(FeatureCardHot featureCardHot) {
        this.cEg = featureCardHot;
    }

    public FeatureCardHot ajx() {
        return this.cEg;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEf;
    }
}
