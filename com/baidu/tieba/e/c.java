package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId exB = BdUniqueId.gen();
    private FeatureCardCompetition exC;
    private Integer exD;
    private Integer exE;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exB;
    }

    public FeatureCardCompetition aUL() {
        return this.exC;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.exC = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.exD = featureCardCompetition.floor;
            this.exE = featureCardCompetition.type;
        }
    }
}
