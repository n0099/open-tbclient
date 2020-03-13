package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements m {
    public static BdUniqueId fQt = BdUniqueId.gen();
    private FeatureCardCompetition fQu;
    private Integer fQv;
    private Integer fQw;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQt;
    }

    public FeatureCardCompetition bwC() {
        return this.fQu;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.fQu = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.fQv = featureCardCompetition.floor;
            this.fQw = featureCardCompetition.type;
        }
    }
}
