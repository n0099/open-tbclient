package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes16.dex */
public class f implements q {
    public static final BdUniqueId hqw = BdUniqueId.gen();
    private Integer hqq;
    private Integer hqr;
    private FeatureCardGame hqx;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hqw;
    }

    public FeatureCardGame cdu() {
        return this.hqx;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.hqx = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.hqq = featureCardGame.floor;
            this.hqr = featureCardGame.type;
        }
    }
}
