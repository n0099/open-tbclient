package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOB = BdUniqueId.gen();
    private FeatureCardHot cOC;

    public void a(FeatureCardHot featureCardHot) {
        this.cOC = featureCardHot;
    }

    public FeatureCardHot anp() {
        return this.cOC;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOB;
    }
}
