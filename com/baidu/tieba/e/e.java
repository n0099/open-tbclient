package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cUs = BdUniqueId.gen();
    private FeatureCardHot cUt;

    public void a(FeatureCardHot featureCardHot) {
        this.cUt = featureCardHot;
    }

    public FeatureCardHot apb() {
        return this.cUt;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUs;
    }
}
