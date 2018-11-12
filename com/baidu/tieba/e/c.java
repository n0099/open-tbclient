package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId ddK = BdUniqueId.gen();
    private FeatureCardCompetition ddL;
    private Integer ddM;
    private Integer ddN;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ddK;
    }

    public FeatureCardCompetition arX() {
        return this.ddL;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.ddL = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.ddM = featureCardCompetition.floor;
            this.ddN = featureCardCompetition.type;
        }
    }
}
