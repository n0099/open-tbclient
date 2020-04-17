package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gvQ = BdUniqueId.gen();
    private FeatureCardHot gvR;

    public void a(FeatureCardHot featureCardHot) {
        this.gvR = featureCardHot;
    }

    public FeatureCardHot bGv() {
        return this.gvR;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvQ;
    }
}
