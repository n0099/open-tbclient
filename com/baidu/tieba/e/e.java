package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fQk = BdUniqueId.gen();
    private FeatureCardHot fQl;

    public void a(FeatureCardHot featureCardHot) {
        this.fQl = featureCardHot;
    }

    public FeatureCardHot bwB() {
        return this.fQl;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQk;
    }
}
