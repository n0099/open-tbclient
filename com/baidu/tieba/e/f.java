package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId eWQ = BdUniqueId.gen();
    private Integer eWK;
    private Integer eWL;
    private FeatureCardGame eWR;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWQ;
    }

    public FeatureCardGame bcB() {
        return this.eWR;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.eWR = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.eWK = featureCardGame.floor;
            this.eWL = featureCardGame.type;
        }
    }
}
