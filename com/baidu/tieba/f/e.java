package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes22.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId iqB = BdUniqueId.gen();
    private FeatureCardHot iqC;

    public void a(FeatureCardHot featureCardHot) {
        this.iqC = featureCardHot;
    }

    public FeatureCardHot ctD() {
        return this.iqC;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqB;
    }
}
