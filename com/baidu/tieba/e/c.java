package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId exP = BdUniqueId.gen();
    private FeatureCardCompetition exQ;
    private Integer exR;
    private Integer exS;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return exP;
    }

    public FeatureCardCompetition aUN() {
        return this.exQ;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.exQ = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.exR = featureCardCompetition.floor;
            this.exS = featureCardCompetition.type;
        }
    }
}
