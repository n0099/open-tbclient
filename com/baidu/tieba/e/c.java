package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes7.dex */
public class c implements m {
    public static BdUniqueId fNJ = BdUniqueId.gen();
    private FeatureCardCompetition fNK;
    private Integer fNL;
    private Integer fNM;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fNJ;
    }

    public FeatureCardCompetition buV() {
        return this.fNK;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.fNK = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.fNL = featureCardCompetition.floor;
            this.fNM = featureCardCompetition.type;
        }
    }
}
