package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eTZ = BdUniqueId.gen();
    private FeatureCardHot eUa;

    public void a(FeatureCardHot featureCardHot) {
        this.eUa = featureCardHot;
    }

    public FeatureCardHot beF() {
        return this.eUa;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eTZ;
    }
}
