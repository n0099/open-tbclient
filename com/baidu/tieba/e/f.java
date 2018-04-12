package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cEh = BdUniqueId.gen();
    private Integer cEb;
    private Integer cEc;
    private FeatureCardGame cEi;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEh;
    }

    public FeatureCardGame ajy() {
        return this.cEi;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cEi = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cEb = featureCardGame.floor;
            this.cEc = featureCardGame.type;
        }
    }
}
