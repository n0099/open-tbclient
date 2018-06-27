package com.baidu.tieba.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.frs.gamerecommend.data.FeatureCardCompetition;
/* loaded from: classes3.dex */
public class c implements com.baidu.adp.widget.ListView.h {
    public static BdUniqueId cLP = BdUniqueId.gen();
    private FeatureCardCompetition cLQ;
    private Integer cLR;
    private Integer cLS;
    private String mTitle;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return cLP;
    }

    public FeatureCardCompetition amM() {
        return this.cLQ;
    }

    public void a(FeatureCardCompetition featureCardCompetition) {
        if (featureCardCompetition != null) {
            this.cLQ = featureCardCompetition;
            this.mTitle = featureCardCompetition.title;
            this.cLR = featureCardCompetition.floor;
            this.cLS = featureCardCompetition.type;
        }
    }
}
