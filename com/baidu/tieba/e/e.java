package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId ieS = BdUniqueId.gen();
    private FeatureCardHot ieT;

    public void a(FeatureCardHot featureCardHot) {
        this.ieT = featureCardHot;
    }

    public FeatureCardHot cpM() {
        return this.ieT;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ieS;
    }
}
