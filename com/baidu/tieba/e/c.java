package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements m {
    public static BdUniqueId fRc = BdUniqueId.gen();
    private FeatureCardCompetition fRd;
    private Integer fRe;
    private Integer fRf;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRc;
    }

    public FeatureCardCompetition bwH() {
        return this.fRd;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.fRd = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.fRe = featureCardCompetition.floor;
            this.fRf = featureCardCompetition.type;
        }
    }
}
