package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes6.dex */
public class c implements m {
    public static BdUniqueId fKA = BdUniqueId.gen();
    private FeatureCardCompetition fKB;
    private Integer fKC;
    private Integer fKD;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fKA;
    }

    public FeatureCardCompetition btT() {
        return this.fKB;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.fKB = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.fKC = featureCardCompetition.floor;
            this.fKD = featureCardCompetition.type;
        }
    }
}
