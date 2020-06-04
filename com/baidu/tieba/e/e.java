package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gKS = BdUniqueId.gen();
    private FeatureCardHot gKT;

    public void a(FeatureCardHot featureCardHot) {
        this.gKT = featureCardHot;
    }

    public FeatureCardHot bMP() {
        return this.gKT;
    }

    @Override // com.baidu.tieba.card.data.b, com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return gKS;
    }
}
