package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eWO = BdUniqueId.gen();
    private FeatureCardHot eWP;

    public void a(FeatureCardHot featureCardHot) {
        this.eWP = featureCardHot;
    }

    public FeatureCardHot bcA() {
        return this.eWP;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWO;
    }
}
