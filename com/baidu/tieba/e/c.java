package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId eNf = BdUniqueId.gen();
    private FeatureCardCompetition eNg;
    private Integer eNh;
    private Integer eNi;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNf;
    }

    public FeatureCardCompetition bbW() {
        return this.eNg;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.eNg = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.eNh = featureCardCompetition.floor;
            this.eNi = featureCardCompetition.type;
        }
    }
}
