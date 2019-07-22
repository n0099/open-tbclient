package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eSl = BdUniqueId.gen();
    private FeatureCardHot eSm;

    public void a(FeatureCardHot featureCardHot) {
        this.eSm = featureCardHot;
    }

    public FeatureCardHot bdZ() {
        return this.eSm;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSl;
    }
}
