package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId exX = BdUniqueId.gen();
    private Integer exR;
    private Integer exS;
    private FeatureCardGame exY;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exX;
    }

    public FeatureCardGame aUQ() {
        return this.exY;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.exY = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.exR = featureCardGame.floor;
            this.exS = featureCardGame.type;
        }
    }
}
