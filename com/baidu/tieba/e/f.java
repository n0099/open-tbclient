package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cEe = BdUniqueId.gen();
    private Integer cDY;
    private Integer cDZ;
    private FeatureCardGame cEf;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cEe;
    }

    public FeatureCardGame ajy() {
        return this.cEf;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cEf = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cDY = featureCardGame.floor;
            this.cDZ = featureCardGame.type;
        }
    }
}
