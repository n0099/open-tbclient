package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId dky = BdUniqueId.gen();
    private FeatureCardHot dkz;

    public void a(FeatureCardHot featureCardHot) {
        this.dkz = featureCardHot;
    }

    public FeatureCardHot atL() {
        return this.dkz;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dky;
    }
}
