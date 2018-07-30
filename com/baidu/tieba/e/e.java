package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardHot;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.card.data.b {
    public static final BdUniqueId cOE = BdUniqueId.gen();
    private FeatureCardHot cOF;

    public void a(FeatureCardHot featureCardHot) {
        this.cOF = featureCardHot;
    }

    public FeatureCardHot ann() {
        return this.cOF;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOE;
    }
}
