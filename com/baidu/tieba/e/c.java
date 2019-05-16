package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId eNe = BdUniqueId.gen();
    private FeatureCardCompetition eNf;
    private Integer eNg;
    private Integer eNh;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eNe;
    }

    public FeatureCardCompetition bbT() {
        return this.eNf;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.eNf = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.eNg = featureCardCompetition.floor;
            this.eNh = featureCardCompetition.type;
        }
    }
}
