package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId eNn = BdUniqueId.gen();
    private Integer eNh;
    private Integer eNi;
    private FeatureCardGame eNo;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNn;
    }

    public FeatureCardGame bbZ() {
        return this.eNo;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.eNo = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.eNh = featureCardGame.floor;
            this.eNi = featureCardGame.type;
        }
    }
}
