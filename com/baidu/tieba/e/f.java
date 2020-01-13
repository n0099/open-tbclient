package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes7.dex */
public class f implements m {
    public static final BdUniqueId fNR = BdUniqueId.gen();
    private Integer fNL;
    private Integer fNM;
    private FeatureCardGame fNS;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNR;
    }

    public FeatureCardGame buY() {
        return this.fNS;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.fNS = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.fNL = featureCardGame.floor;
            this.fNM = featureCardGame.type;
        }
    }
}
