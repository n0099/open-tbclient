package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId eTT = BdUniqueId.gen();
    private FeatureCardCompetition eTU;
    private Integer eTV;
    private Integer eTW;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eTT;
    }

    public FeatureCardCompetition beD() {
        return this.eTU;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.eTU = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.eTV = featureCardCompetition.floor;
            this.eTW = featureCardCompetition.type;
        }
    }
}
