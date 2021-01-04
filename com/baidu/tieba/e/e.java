package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes2.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId iCX = BdUniqueId.gen();
    private FeatureCardHot iCY;

    public void a(FeatureCardHot featureCardHot) {
        this.iCY = featureCardHot;
    }

    public FeatureCardHot cwx() {
        return this.iCY;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iCX;
    }
}
