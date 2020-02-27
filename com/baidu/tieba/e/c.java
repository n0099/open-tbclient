package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements m {
    public static BdUniqueId fQe = BdUniqueId.gen();
    private FeatureCardCompetition fQf;
    private Integer fQg;
    private Integer fQh;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fQe;
    }

    public FeatureCardCompetition bwz() {
        return this.fQf;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.fQf = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.fQg = featureCardCompetition.floor;
            this.fQh = featureCardCompetition.type;
        }
    }
}
