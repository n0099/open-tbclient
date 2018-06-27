package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cLV = BdUniqueId.gen();
    private FeatureCardHot cLW;

    public void a(FeatureCardHot featureCardHot) {
        this.cLW = featureCardHot;
    }

    public FeatureCardHot amO() {
        return this.cLW;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cLV;
    }
}
