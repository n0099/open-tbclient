package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId exV = BdUniqueId.gen();
    private FeatureCardHot exW;

    public void a(FeatureCardHot featureCardHot) {
        this.exW = featureCardHot;
    }

    public FeatureCardHot aUP() {
        return this.exW;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exV;
    }
}
