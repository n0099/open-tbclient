package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes7.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fNP = BdUniqueId.gen();
    private FeatureCardHot fNQ;

    public void a(FeatureCardHot featureCardHot) {
        this.fNQ = featureCardHot;
    }

    public FeatureCardHot buX() {
        return this.fNQ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNP;
    }
}
