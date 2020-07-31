package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId hdu = BdUniqueId.gen();
    private FeatureCardHot hdv;

    public void a(FeatureCardHot featureCardHot) {
        this.hdv = featureCardHot;
    }

    public FeatureCardHot bTg() {
        return this.hdv;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hdu;
    }
}
