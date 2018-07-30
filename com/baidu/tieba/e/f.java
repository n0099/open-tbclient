package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes3.dex */
public class f implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId cOG = BdUniqueId.gen();
    private Integer cOA;
    private Integer cOB;
    private FeatureCardGame cOH;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cOG;
    }

    public FeatureCardGame ano() {
        return this.cOH;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.cOH = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.cOA = featureCardGame.floor;
            this.cOB = featureCardGame.type;
        }
    }
}
