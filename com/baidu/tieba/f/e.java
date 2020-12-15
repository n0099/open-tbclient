package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes22.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId iqD = BdUniqueId.gen();
    private FeatureCardHot iqE;

    public void a(FeatureCardHot featureCardHot) {
        this.iqE = featureCardHot;
    }

    public FeatureCardHot ctE() {
        return this.iqE;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iqD;
    }
}
