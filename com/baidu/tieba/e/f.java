package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cLX = BdUniqueId.gen();
    private Integer cLR;
    private Integer cLS;
    private FeatureCardGame cLY;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cLX;
    }

    public FeatureCardGame amP() {
        return this.cLY;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cLY = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cLR = featureCardGame.floor;
            this.cLS = featureCardGame.type;
        }
    }
}
