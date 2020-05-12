package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements m {
    public static final BdUniqueId gvY = BdUniqueId.gen();
    private Integer gvS;
    private Integer gvT;
    private FeatureCardGame gvZ;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvY;
    }

    public FeatureCardGame bGv() {
        return this.gvZ;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.gvZ = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.gvS = featureCardGame.floor;
            this.gvT = featureCardGame.type;
        }
    }
}
