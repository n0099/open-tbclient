package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes2.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId iFX = BdUniqueId.gen();
    private FeatureCardHot iFY;

    public void a(FeatureCardHot featureCardHot) {
        this.iFY = featureCardHot;
    }

    public FeatureCardHot cuf() {
        return this.iFY;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iFX;
    }
}
