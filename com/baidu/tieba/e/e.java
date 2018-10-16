package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dcK = BdUniqueId.gen();
    private FeatureCardHot dcL;

    public void a(FeatureCardHot featureCardHot) {
        this.dcL = featureCardHot;
    }

    public FeatureCardHot asz() {
        return this.dcL;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcK;
    }
}
