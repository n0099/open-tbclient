package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId gvW = BdUniqueId.gen();
    private FeatureCardHot gvX;

    public void a(FeatureCardHot featureCardHot) {
        this.gvX = featureCardHot;
    }

    public FeatureCardHot bGu() {
        return this.gvX;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvW;
    }
}
