package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hqo = BdUniqueId.gen();
    private FeatureCardHot hqp;

    public void a(FeatureCardHot featureCardHot) {
        this.hqp = featureCardHot;
    }

    public FeatureCardHot cds() {
        return this.hqp;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqo;
    }
}
