package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQz = BdUniqueId.gen();
    private FeatureCardHot fQA;

    public void a(FeatureCardHot featureCardHot) {
        this.fQA = featureCardHot;
    }

    public FeatureCardHot bwE() {
        return this.fQA;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQz;
    }
}
