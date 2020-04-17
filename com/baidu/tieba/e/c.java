package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes9.dex */
public class c implements m {
    public static BdUniqueId gvK = BdUniqueId.gen();
    private FeatureCardCompetition gvL;
    private Integer gvM;
    private Integer gvN;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gvK;
    }

    public FeatureCardCompetition bGt() {
        return this.gvL;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.gvL = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.gvM = featureCardCompetition.floor;
            this.gvN = featureCardCompetition.type;
        }
    }
}
