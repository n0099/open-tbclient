package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes21.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hxz = BdUniqueId.gen();
    private FeatureCardHot hxA;

    public void a(FeatureCardHot featureCardHot) {
        this.hxA = featureCardHot;
    }

    public FeatureCardHot cgI() {
        return this.hxA;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hxz;
    }
}
