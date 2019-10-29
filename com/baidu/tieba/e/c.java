package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId eWI = BdUniqueId.gen();
    private FeatureCardCompetition eWJ;
    private Integer eWK;
    private Integer eWL;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eWI;
    }

    public FeatureCardCompetition bcy() {
        return this.eWJ;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.eWJ = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.eWK = featureCardCompetition.floor;
            this.eWL = featureCardCompetition.type;
        }
    }
}
