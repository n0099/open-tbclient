package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes22.dex */
public class f implements q {
    public static final BdUniqueId hYT = BdUniqueId.gen();
    private Integer hYN;
    private Integer hYO;
    private FeatureCardGame hYU;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hYT;
    }

    public FeatureCardGame cnm() {
        return this.hYU;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.hYU = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.hYN = featureCardGame.floor;
            this.hYO = featureCardGame.type;
        }
    }
}
