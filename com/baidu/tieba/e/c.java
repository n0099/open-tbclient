package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId eVR = BdUniqueId.gen();
    private FeatureCardCompetition eVS;
    private Integer eVT;
    private Integer eVU;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eVR;
    }

    public FeatureCardCompetition bcw() {
        return this.eVS;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.eVS = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.eVT = featureCardCompetition.floor;
            this.eVU = featureCardCompetition.type;
        }
    }
}
