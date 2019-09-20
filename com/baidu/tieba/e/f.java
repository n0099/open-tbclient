package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId eUb = BdUniqueId.gen();
    private Integer eTV;
    private Integer eTW;
    private FeatureCardGame eUc;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eUb;
    }

    public FeatureCardGame beG() {
        return this.eUc;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.eUc = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.eTV = featureCardGame.floor;
            this.eTW = featureCardGame.type;
        }
    }
}
