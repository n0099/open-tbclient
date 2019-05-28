package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId eNl = BdUniqueId.gen();
    private FeatureCardHot eNm;

    public void a(FeatureCardHot featureCardHot) {
        this.eNm = featureCardHot;
    }

    public FeatureCardHot bbY() {
        return this.eNm;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNl;
    }
}
