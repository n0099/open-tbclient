package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId exI = BdUniqueId.gen();
    private Integer exC;
    private Integer exD;
    private FeatureCardGame exJ;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exI;
    }

    public FeatureCardGame aUO() {
        return this.exJ;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.exJ = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.exC = featureCardGame.floor;
            this.exD = featureCardGame.type;
        }
    }
}
