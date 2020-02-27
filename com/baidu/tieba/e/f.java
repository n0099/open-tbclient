package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements m {
    public static final BdUniqueId fQm = BdUniqueId.gen();
    private Integer fQg;
    private Integer fQh;
    private FeatureCardGame fQn;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQm;
    }

    public FeatureCardGame bwC() {
        return this.fQn;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.fQn = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.fQg = featureCardGame.floor;
            this.fQh = featureCardGame.type;
        }
    }
}
