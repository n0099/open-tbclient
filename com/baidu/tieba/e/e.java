package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eSs = BdUniqueId.gen();
    private FeatureCardHot eSt;

    public void a(FeatureCardHot featureCardHot) {
        this.eSt = featureCardHot;
    }

    public FeatureCardHot beb() {
        return this.eSt;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSs;
    }
}
