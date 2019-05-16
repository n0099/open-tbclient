package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNk = BdUniqueId.gen();
    private FeatureCardHot eNl;

    public void a(FeatureCardHot featureCardHot) {
        this.eNl = featureCardHot;
    }

    public FeatureCardHot bbV() {
        return this.eNl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNk;
    }
}
