package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId exJ = BdUniqueId.gen();
    private Integer exD;
    private Integer exE;
    private FeatureCardGame exK;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exJ;
    }

    public FeatureCardGame aUO() {
        return this.exK;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.exK = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.exD = featureCardGame.floor;
            this.exE = featureCardGame.type;
        }
    }
}
