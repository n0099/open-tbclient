package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes9.dex */
public class f implements m {
    public static final BdUniqueId fQB = BdUniqueId.gen();
    private FeatureCardGame fQC;
    private Integer fQv;
    private Integer fQw;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQB;
    }

    public FeatureCardGame bwF() {
        return this.fQC;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.fQC = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.fQv = featureCardGame.floor;
            this.fQw = featureCardGame.type;
        }
    }
}
