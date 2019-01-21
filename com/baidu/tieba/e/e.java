package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dod = BdUniqueId.gen();
    private FeatureCardHot doe;

    public void a(FeatureCardHot featureCardHot) {
        this.doe = featureCardHot;
    }

    public FeatureCardHot auY() {
        return this.doe;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dod;
    }
}
