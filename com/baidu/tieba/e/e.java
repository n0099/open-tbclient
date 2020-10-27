package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hYR = BdUniqueId.gen();
    private FeatureCardHot hYS;

    public void a(FeatureCardHot featureCardHot) {
        this.hYS = featureCardHot;
    }

    public FeatureCardHot cnl() {
        return this.hYS;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYR;
    }
}
