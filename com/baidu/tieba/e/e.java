package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gXP = BdUniqueId.gen();
    private FeatureCardHot gXQ;

    public void a(FeatureCardHot featureCardHot) {
        this.gXQ = featureCardHot;
    }

    public FeatureCardHot bPU() {
        return this.gXQ;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return gXP;
    }
}
