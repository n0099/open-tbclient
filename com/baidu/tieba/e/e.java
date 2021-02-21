package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes2.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId iEo = BdUniqueId.gen();
    private FeatureCardHot iEp;

    public void a(FeatureCardHot featureCardHot) {
        this.iEp = featureCardHot;
    }

    public FeatureCardHot ctZ() {
        return this.iEp;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iEo;
    }
}
