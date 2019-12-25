package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes6.dex */
public class f implements m {
    public static final BdUniqueId fKI = BdUniqueId.gen();
    private Integer fKC;
    private Integer fKD;
    private FeatureCardGame fKJ;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKI;
    }

    public FeatureCardGame btW() {
        return this.fKJ;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.fKJ = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.fKC = featureCardGame.floor;
            this.fKD = featureCardGame.type;
        }
    }
}
