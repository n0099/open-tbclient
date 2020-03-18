package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements m {
    public static final BdUniqueId fRk = BdUniqueId.gen();
    private Integer fRe;
    private Integer fRf;
    private FeatureCardGame fRl;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRk;
    }

    public FeatureCardGame bwK() {
        return this.fRl;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.fRl = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.fRe = featureCardGame.floor;
            this.fRf = featureCardGame.type;
        }
    }
}
