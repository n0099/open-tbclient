package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId eSm = BdUniqueId.gen();
    private FeatureCardCompetition eSn;
    private Integer eSo;
    private Integer eSp;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSm;
    }

    public FeatureCardCompetition bdZ() {
        return this.eSn;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.eSn = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.eSo = featureCardCompetition.floor;
            this.eSp = featureCardCompetition.type;
        }
    }
}
