package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId dcE = BdUniqueId.gen();
    private FeatureCardCompetition dcF;
    private Integer dcG;
    private Integer dcH;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dcE;
    }

    public FeatureCardCompetition asx() {
        return this.dcF;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.dcF = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.dcG = featureCardCompetition.floor;
            this.dcH = featureCardCompetition.type;
        }
    }
}
