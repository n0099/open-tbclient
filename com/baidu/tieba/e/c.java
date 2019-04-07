package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId exA = BdUniqueId.gen();
    private FeatureCardCompetition exB;
    private Integer exC;
    private Integer exD;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exA;
    }

    public FeatureCardCompetition aUL() {
        return this.exB;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.exB = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.exC = featureCardCompetition.floor;
            this.exD = featureCardCompetition.type;
        }
    }
}
