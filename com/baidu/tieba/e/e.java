package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQm = BdUniqueId.gen();
    private FeatureCardHot fQn;

    public void a(FeatureCardHot featureCardHot) {
        this.fQn = featureCardHot;
    }

    public FeatureCardHot bwD() {
        return this.fQn;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQm;
    }
}
