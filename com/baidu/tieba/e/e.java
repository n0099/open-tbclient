package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exG = BdUniqueId.gen();
    private FeatureCardHot exH;

    public void a(FeatureCardHot featureCardHot) {
        this.exH = featureCardHot;
    }

    public FeatureCardHot aUN() {
        return this.exH;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exG;
    }
}
