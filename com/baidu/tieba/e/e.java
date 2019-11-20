package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eVX = BdUniqueId.gen();
    private FeatureCardHot eVY;

    public void a(FeatureCardHot featureCardHot) {
        this.eVY = featureCardHot;
    }

    public FeatureCardHot bcy() {
        return this.eVY;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVX;
    }
}
