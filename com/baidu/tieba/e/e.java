package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dob = BdUniqueId.gen();
    private FeatureCardHot dod;

    public void a(FeatureCardHot featureCardHot) {
        this.dod = featureCardHot;
    }

    public FeatureCardHot auY() {
        return this.dod;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dob;
    }
}
