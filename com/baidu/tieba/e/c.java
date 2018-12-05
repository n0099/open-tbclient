package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dks = BdUniqueId.gen();
    private FeatureCardCompetition dkt;
    private Integer dku;
    private Integer dkv;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dks;
    }

    public FeatureCardCompetition atJ() {
        return this.dkt;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.dkt = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.dku = featureCardCompetition.floor;
            this.dkv = featureCardCompetition.type;
        }
    }
}
