package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes21.dex */
public class f implements q {
    public static final BdUniqueId hxB = BdUniqueId.gen();
    private FeatureCardGame hxC;
    private Integer hxv;
    private Integer hxw;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return hxB;
    }

    public FeatureCardGame cgJ() {
        return this.hxC;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.hxC = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.hxv = featureCardGame.floor;
            this.hxw = featureCardGame.type;
        }
    }
}
