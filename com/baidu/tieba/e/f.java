package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dkA = BdUniqueId.gen();
    private FeatureCardGame dkB;
    private Integer dku;
    private Integer dkv;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dkA;
    }

    public FeatureCardGame atM() {
        return this.dkB;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.dkB = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.dku = featureCardGame.floor;
            this.dkv = featureCardGame.type;
        }
    }
}
