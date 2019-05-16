package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardGame;
/* loaded from: classes4.dex */
public class f implements m {
    public static final BdUniqueId eNm = BdUniqueId.gen();
    private Integer eNg;
    private Integer eNh;
    private FeatureCardGame eNn;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNm;
    }

    public FeatureCardGame bbW() {
        return this.eNn;
    }

    public void a(FeatureCardGame featureCardGame) {
        if (featureCardGame != null) {
            this.eNn = featureCardGame;
            this.mTitle = featureCardGame.title;
            this.eNg = featureCardGame.floor;
            this.eNh = featureCardGame.type;
        }
    }
}
