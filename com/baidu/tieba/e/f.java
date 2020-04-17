package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements m {
    public static final BdUniqueId gvS = BdUniqueId.gen();
    private Integer gvM;
    private Integer gvN;
    private FeatureCardGame gvT;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvS;
    }

    public FeatureCardGame bGw() {
        return this.gvT;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.gvT = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.gvM = featureCardGame.floor;
            this.gvN = featureCardGame.type;
        }
    }
}
