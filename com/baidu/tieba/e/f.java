package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes22.dex */
public class f implements q {
    public static final BdUniqueId hMw = BdUniqueId.gen();
    private Integer hMq;
    private Integer hMr;
    private FeatureCardGame hMx;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hMw;
    }

    public FeatureCardGame ckf() {
        return this.hMx;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.hMx = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.hMq = featureCardGame.floor;
            this.hMr = featureCardGame.type;
        }
    }
}
