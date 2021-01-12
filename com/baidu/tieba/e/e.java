package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes2.dex */
public class e extends BaseCardInfo {
    public static final BdUniqueId iyq = BdUniqueId.gen();
    private FeatureCardHot iyr;

    public void a(FeatureCardHot featureCardHot) {
        this.iyr = featureCardHot;
    }

    public FeatureCardHot csG() {
        return this.iyr;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return iyq;
    }
}
