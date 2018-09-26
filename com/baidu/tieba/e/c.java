package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cUm = BdUniqueId.gen();
    private FeatureCardCompetition cUn;
    private Integer cUo;
    private Integer cUp;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cUm;
    }

    public FeatureCardCompetition aoZ() {
        return this.cUn;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cUn = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cUo = featureCardCompetition.floor;
            this.cUp = featureCardCompetition.type;
        }
    }
}
