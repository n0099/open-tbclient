package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exH = BdUniqueId.gen();
    private FeatureCardHot exI;

    public void a(FeatureCardHot featureCardHot) {
        this.exI = featureCardHot;
    }

    public FeatureCardHot aUN() {
        return this.exI;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exH;
    }
}
