package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements m {
    public static BdUniqueId gvQ = BdUniqueId.gen();
    private FeatureCardCompetition gvR;
    private Integer gvS;
    private Integer gvT;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvQ;
    }

    public FeatureCardCompetition bGr() {
        return this.gvR;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.gvR = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.gvS = featureCardCompetition.floor;
            this.gvT = featureCardCompetition.type;
        }
    }
}
