package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes4.dex */
public class c implements m {
    public static BdUniqueId eSf = BdUniqueId.gen();
    private FeatureCardCompetition eSg;
    private Integer eSh;
    private Integer eSi;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return eSf;
    }

    public FeatureCardCompetition bdX() {
        return this.eSg;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.eSg = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.eSh = featureCardCompetition.floor;
            this.eSi = featureCardCompetition.type;
        }
    }
}
