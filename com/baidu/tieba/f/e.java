package com.baidu.tieba.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes21.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId ifH = BdUniqueId.gen();
    private FeatureCardHot ifI;

    public void a(FeatureCardHot featureCardHot) {
        this.ifI = featureCardHot;
    }

    public FeatureCardHot cpp() {
        return this.ifI;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ifH;
    }
}
