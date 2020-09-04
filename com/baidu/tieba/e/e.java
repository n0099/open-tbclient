package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqu = BdUniqueId.gen();
    private FeatureCardHot hqv;

    public void a(FeatureCardHot featureCardHot) {
        this.hqv = featureCardHot;
    }

    public FeatureCardHot cdt() {
        return this.hqv;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqu;
    }
}
