package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements m {
    public static BdUniqueId fQg = BdUniqueId.gen();
    private FeatureCardCompetition fQh;
    private Integer fQi;
    private Integer fQj;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQg;
    }

    public FeatureCardCompetition bwB() {
        return this.fQh;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.fQh = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.fQi = featureCardCompetition.floor;
            this.fQj = featureCardCompetition.type;
        }
    }
}
