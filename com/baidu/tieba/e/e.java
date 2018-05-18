package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cFl = BdUniqueId.gen();
    private FeatureCardHot cFm;

    public void a(FeatureCardHot featureCardHot) {
        this.cFm = featureCardHot;
    }

    public FeatureCardHot ajx() {
        return this.cFm;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cFl;
    }
}
