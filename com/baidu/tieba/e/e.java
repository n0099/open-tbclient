package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hMu = BdUniqueId.gen();
    private FeatureCardHot hMv;

    public void a(FeatureCardHot featureCardHot) {
        this.hMv = featureCardHot;
    }

    public FeatureCardHot cke() {
        return this.hMv;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hMu;
    }
}
