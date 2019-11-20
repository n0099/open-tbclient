package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId eVZ = BdUniqueId.gen();
    private Integer eVT;
    private Integer eVU;
    private FeatureCardGame eWa;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVZ;
    }

    public FeatureCardGame bcz() {
        return this.eWa;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.eWa = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.eVT = featureCardGame.floor;
            this.eVU = featureCardGame.type;
        }
    }
}
