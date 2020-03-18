package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fRi = BdUniqueId.gen();
    private FeatureCardHot fRj;

    public void a(FeatureCardHot featureCardHot) {
        this.fRj = featureCardHot;
    }

    public FeatureCardHot bwJ() {
        return this.fRj;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRi;
    }
}
