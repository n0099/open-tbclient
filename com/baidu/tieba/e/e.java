package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId fKG = BdUniqueId.gen();
    private FeatureCardHot fKH;

    public void a(FeatureCardHot featureCardHot) {
        this.fKH = featureCardHot;
    }

    public FeatureCardHot btV() {
        return this.fKH;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKG;
    }
}
