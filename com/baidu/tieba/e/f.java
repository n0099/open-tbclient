package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements m {
    public static final BdUniqueId fQo = BdUniqueId.gen();
    private Integer fQi;
    private Integer fQj;
    private FeatureCardGame fQp;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQo;
    }

    public FeatureCardGame bwE() {
        return this.fQp;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.fQp = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.fQi = featureCardGame.floor;
            this.fQj = featureCardGame.type;
        }
    }
}
